package nexjon.clinic.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import nexjon.clinic.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		@NotBlank
		String email,
		@NotBlank
		String nome,
		DadosEndereco endereco,
		String telefone) {

}
