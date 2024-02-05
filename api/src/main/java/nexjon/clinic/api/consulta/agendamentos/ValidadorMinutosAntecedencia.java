package nexjon.clinic.api.consulta.agendamentos;

import nexjon.clinic.api.consulta.DadosAgendamentoConsulta;
import nexjon.clinic.api.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorMinutosAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaMinutos < 30){
            throw new ValidacaoException(" Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }
}
