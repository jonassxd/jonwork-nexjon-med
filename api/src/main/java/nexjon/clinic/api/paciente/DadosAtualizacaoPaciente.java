package nexjon.clinic.api.paciente;

import jakarta.validation.constraints.NotNull;
import nexjon.clinic.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
		@NotNull
		Long id,
		String nome,
		DadosEndereco endereco,
		String telefone) {

}
