package nexjon.clinic.api.consulta.agendamentos;

import nexjon.clinic.api.consulta.DadosAgendamentoConsulta;
import nexjon.clinic.api.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramentoClinica = dataConsulta.getHour() > 18;
        if(domingo || antesAberturaClinica || depoisEncerramentoClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clínica");
        }
    }
}
