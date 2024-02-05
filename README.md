# Bem-vindo ao Repositório do Sistema NexjonMed

Este é o repositório do sistema da clínica NexjonMed, uma clínica fictícia que faz parte da rede empresarial fictícia Jonwork. O projeto foi desenvolvido para atender às necessidades básicas de uma clínica, oferecendo uma solução eficaz para a equipe médica e administrativa.

## Funcionalidades Principais:


- **CRUD (Create, Read, Update e Delete):**
  - Gerenciamento completo de Médicos e Pacientes.
  - Agendamento e Cancelamento de consultas.
  - Implementação de validações, paginação e ordenação para aprimorar a experiência do usuário.

- **Tratamento de Erros:**
  - Implementação de mecanismos robustos para o tratamento eficiente de erros.

- **Segurança da API:**
  - Utilização do Spring Security para autenticação e autorização.
  - Controle de acesso com JWT (JSON Web Token) para garantir a segurança da aplicação.

  **Funcionalidade de Cadastro de Médicos:**

Para registrar um novo médico no sistema NexjonMed, siga o processo abaixo, fornecendo as informações obrigatórias:

- Nome: Nome  do médico.
- Email: Endereço de email  do médico.
- CRM (Conselho Regional de Medicina):** Número de registro profissional do médico.
- Telefone: Número de telefone de contato do médico.
- Especialidade: Área de especialização do médico.
- Endereço: Localização física do consultório ou clínica do médico.

**Edição de Informações do Médico:**

Ao editar as informações de um médico no sistema NexjonMed, é possível modificar apenas os seguintes dados:

- Id: Identificador único associado ao médico.
- Email: Endereço de email do médico.
- Nome: Nome  do médico.
- Endereço: Localização física do consultório ou clínica do médico.
- Telefone: Número de telefone de contato do médico.

**Funcionalidade de Cadastro de Pacientes:**

Para cadastrar um novo paciente no sistema NexjonMed, basta seguir o processo abaixo, fornecendo as informações obrigatórias:

- Nome: Nome completo do paciente.
- Email: Endereço de email do paciente.
- CPF (Cadastro de Pessoa Física): Número de registro de pessoa física do paciente.
- Telefone: Número de telefone de contato do paciente.
- Endereço: Localização da residência do paciente.

**Edição de Informações do Paciente:**

Ao editar as informações de um paciente no sistema NexjonMed, é possível modificar apenas os seguintes dados:

- Id: Identificador único associado ao paciente.
- Nome: Nome  do paciente.
- Endereço: Localização da residência do paciente.
- Telefone: Número de telefone de contato do paciente.



  **Funcionalidade de Agendamento e Cancelamento de Consultas:**
  - Regras de negócio integradas para agendar consultas com antecedência e cancelar com um prazo mínimo.
  - Informações essenciais, como data e especialidade do médico, são requisitos para o agendamento.

 **Validações de Integridade da API:**
  - Implementação de validações para garantir a integridade dos dados na API.

 **Documentação da API:**
  - Utilização do Swagger e SpringDoc para documentação clara e acessível.

 **Testes Unitários Automatizados:**
  - Utilização do Mockito para a criação de testes unitários automatizados.

**Ambiente de Desenvolvimento**:

## IDE:
  - Intellij IDEA

## Plataforma de API:
  - Postman e Insomnia

## Banco de Dados:

## Postgres:
  - Banco de dados utilizado para armazenamento e gerenciamento eficiente dos dados da clínica.
