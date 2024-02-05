package nexjon.clinic.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nexjon.clinic.api.endereco.Endereco;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	@Embedded
	private Endereco endereco;

	public Paciente(DadosCadastroPaciente dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
	}

	public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
		if(dados.nome()!= null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco()!= null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

}


