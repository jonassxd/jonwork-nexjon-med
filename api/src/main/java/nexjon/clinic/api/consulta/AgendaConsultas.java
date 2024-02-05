package nexjon.clinic.api.consulta;

import nexjon.clinic.api.consulta.cancelamento.ValidadorCancelamentoConsulta;
import nexjon.clinic.api.consulta.agendamentos.ValidadorAgendamentoConsulta;
import nexjon.clinic.api.controller.DadosCancelamentoConsulta;
import nexjon.clinic.api.infra.exceptions.ValidacaoException;
import nexjon.clinic.api.medico.Medico;
import nexjon.clinic.api.medico.MedicoRepository;
import nexjon.clinic.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;
    @Autowired
    private List<ValidadorCancelamentoConsulta> validadoresCancelamento;
    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente informado, não existe!");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoException("Não existe médico disponível nesta data");

        }
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

        public void cancelar(DadosCancelamentoConsulta dados){
            if(!consultaRepository.existsById(dados.idConsulta())){
                throw new ValidacaoException("Id da consulta informado não existe");
            }
            validadoresCancelamento.forEach(v -> v.validar(dados));
    }


    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico()!= null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        else if(dados.especialidade() == null){
            throw  new ValidacaoException("Especialidade é obrigátoria, quando não for escolhido um médico");
        }
        return medicoRepository.escolherMedicoRandomLivreNaData(dados.especialidade(), dados.data());
    }



    }

