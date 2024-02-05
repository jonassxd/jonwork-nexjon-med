package nexjon.clinic.api.consulta.cancelamento;

import nexjon.clinic.api.consulta.ConsultaRepository;
import nexjon.clinic.api.controller.DadosCancelamentoConsulta;
import nexjon.clinic.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaHoras = Duration.between(agora, consulta.getData()).toHours();

        if(diferencaHoras < 24){
            throw new ValidacaoException("Consulta só pode ser cancelada com antecedência minima de 24 horas.");
        }
    }
}
