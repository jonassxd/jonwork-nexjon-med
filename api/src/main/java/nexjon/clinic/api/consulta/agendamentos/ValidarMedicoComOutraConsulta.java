package nexjon.clinic.api.consulta.agendamentos;

import nexjon.clinic.api.consulta.ConsultaRepository;
import nexjon.clinic.api.consulta.DadosAgendamentoConsulta;
import nexjon.clinic.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoComOutraConsulta  implements ValidadorAgendamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraConsultaMesmaHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutraConsultaMesmaHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada no mesmo horário");
        }
    }
}
