package nexjon.clinic.api.controller;

import nexjon.clinic.api.endereco.DadosEndereco;
import nexjon.clinic.api.medico.DadosCadastroMedico;
import nexjon.clinic.api.medico.Especialidade;
import nexjon.clinic.api.medico.Medico;
import nexjon.clinic.api.paciente.DadosCadastroPaciente;
import nexjon.clinic.api.paciente.Paciente;
import nexjon.clinic.api.paciente.PacienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PacienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroPaciente> dadosCadastroPacienteJson;

    @MockBean
    private PacienteRepository pacienteRepository;


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser

    void cadastrar_cenario1() throws Exception {
        var response = mvc
                .perform(post("/paciente"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var dadosCadastro = new DadosCadastroPaciente(
                "Paciente",
                "paciente@nexjon.med",
                "739.911.040-91",
                "199392949",
                dadosEndereco());

        System.out.println("Dados de Cadastro: " + dadosCadastro);

        when(pacienteRepository.save(any())).thenReturn(new Paciente(dadosCadastro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroPacienteJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua jose  das flores",
                "bairro de maluco",
                "131241251",
                "Campinas",
                "SP",
                "frente da casa do seu zé",
                "134"
        );
    }
}
