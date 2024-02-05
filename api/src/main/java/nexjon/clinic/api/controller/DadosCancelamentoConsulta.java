package nexjon.clinic.api.controller;

import jakarta.validation.constraints.NotNull;
import nexjon.clinic.api.consulta.MotivoCancelamento;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo
) {
}
