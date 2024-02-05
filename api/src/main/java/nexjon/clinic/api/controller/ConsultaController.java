package nexjon.clinic.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import nexjon.clinic.api.consulta.AgendaConsultas;
import nexjon.clinic.api.consulta.DadosAgendamentoConsulta;
import nexjon.clinic.api.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity<?> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
      var dto =  agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity<?> cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}