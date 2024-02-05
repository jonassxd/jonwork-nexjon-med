package nexjon.clinic.api.paciente;

public record DadosDetalhamentoPaciente(
		Long id,
		String nome,
		String email,
		String cpf,
		String telefone) {

	
	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
	}
}
