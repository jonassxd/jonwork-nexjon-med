package nexjon.clinic.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import nexjon.clinic.api.medico.DadosAtualizacaoMedico;
import nexjon.clinic.api.medico.DadosCadastroMedico;
import nexjon.clinic.api.medico.DadosDetalhamentoMedico;
import nexjon.clinic.api.medico.Medico;
import nexjon.clinic.api.paciente.DadosAtualizacaoPaciente;
import nexjon.clinic.api.paciente.DadosCadastroPaciente;
import nexjon.clinic.api.paciente.DadosDetalhamentoPaciente;
import nexjon.clinic.api.paciente.DadosListagemPaciente;
import nexjon.clinic.api.paciente.Paciente;
import nexjon.clinic.api.paciente.PacienteRepository;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

	@Autowired
	PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
		var paciente = new Paciente(dados);
		repository.save(paciente);
		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
	}

	@GetMapping
	    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"} )Pageable paginacao) {
	        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> selecionarPorId(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	@PutMapping
	@Transactional
		public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
			var paciente = repository.getReferenceById(dados.id());
			paciente.atualizarInformacoes(dados);
			return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente)); 
	}
	
	 @DeleteMapping("/{id}")
	   @Transactional
	   public void excluir(@PathVariable Long id) {
		   repository.deleteById(id);
	   }
}
