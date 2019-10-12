<<<<<<< README.md
# Analise de Credito

Foi criada uma aplicação com o back-end em Spring Boot.
Para persistir os dados foi utilizado banco de dados MySql.
Como gerenciador de dependencias foi utilizado o Maven.
Foi criada uma pequena interface em Swagger para consumir as APIs.

# Executando o projeto
1. Criar um banco no Mysql chamado analisecredito
Obs.: A aplicação está configurada para rodar na porta 8081, caso necessário alterar, fazer isso no arquivo: application.properties no diretório src/main/resources
2. Rodar a aplicação AnalisecreditoApplication.java (Run As -> Spring Boot App)
3. Abrir no navegador http://localhost:8081/swagger-ui.html para testar as operações

# Dicionário

Cliente - Possíveis portadores de cartões
Usuário - Usuário do sistema podendo ser tipo 1 (Usuário de capitação) ou 2 (Usuário analista)

# Executando os testes no Swagger

### Operação "Filtro de clientes Aprovados/Negados ou Aguardando"

Este serviço verifica o ID do usuário que o está acessando, caso seja usuário tipo 1 (Captador)
serão exibidos clientes aprovados ou negados, caso seja tipo 2 (Analista) serão exibidos clientes 
que estão aguardando o análise.

### Operação "Cadastrar Cliente"
Este serviço verifica o ID do usuário que o está acessando, caso seja usuário tipo 1 (Captador),
ele conseguirá cadastrar um novo cliente, caso seja 2 (Analista) o serviço retornará nulo.


### Consulta Cliente pelo CPF
Este serviço verifica consulta clientes cadastrados através do CPF.
Como não foi feita validação quanto a cpfs repetidos, o serviço retorna uma lista.
Esta consulta está liberada para qualquer usuário.

### Deletar
Este serviço deleta um cliente.
Está liberado para qualquer usuário

### Aprova/Nega um cliente
Este serviço aprova ou nega um cliente pelo id
será feita a alteração apenas se o usuário for tipo 2 (Analista).
Para negar, inserir valor 1, para aprovar, inserir qualquer outro valor.

### Atualiza um cliente
Este serviço altera os dados de um cliente.
Está liberado para qualquer usuário.
=======
# desafio-analise-credito

### Desafio Conductor de Seleção 
Olá, queremos convidá-lo a participar de nosso desafio de seleção.  Pronto para participar? Seu trabalho será visto por nosso time e você receberá ao final um feedback sobre o que achamos do seu trabalho. Não é legal?

### Sobre a oportunidade 
A vaga é para Desenvolvedor Java, temos vagas com diversos níveis de senioridade e para cada um deles utilizaremos critérios específicos considerando esse aspecto, combinado? 
Se você for aprovado nesta etapa, será convidado para uma entrevista final com nosso time técnico.

### Desafio Técnico
  Desenvolver um sistema de análise de crédito para novos portadores de cartão, onde devemos ter usuários com dois tipos de permissão, sendo eles:
    * Usuário de captação de propostas de novos cartões: este usuário será responsável pelo cadastro de novos portadores de cartão.  Após o cadastro dos portadores, este usuário terá permissão apenas de verificar o resultado das análises realizadas pelos analistas.
    * Usuário analista de crédito: este usuário será responsável por verificar as propostas cadastradas, podendo aprovar ou negar a concessão de crédito. O resultado da análise será disponibilizado para o usuário de captação de proposta.
    
  - Dicionário:
    ```
    * Portador de cartão: toda pessoa que tem sua análise de crédito aprovada.
    * Análise de crédito: o processo pelo qual o analista verifica documentos, spc e quaisquer dados disponíveis para concessão de crédito.
    ```
    
  - Pré-requisitos:
    ```
    * Utilização do SGBD Oracle, MySQL ou Postgres.
    * JDK 1.8+
    * Maven 3+ (ou gradle,  ou afins)
    * JUnit 4+
    * Framework Web a critério (Servlets, JSF, Spring MVC ou afins, preferencialmente Angular)
    * Criação de um DUMP com massa de dados.
    ```

  - O que esperamos como escopo:
    ```
    * Adicionar e Manter propostas de crédito;
    * Consultar propostas de crédito, por filtros de dados;
    * Painel de análise de crédito, contendo todos os clientes cadastrados mas que não foram analisados ainda;
    * Perfis diferentes para o usuário que realiza a captação da proposta e o usuário que realiza a análise;
    ```
  - O que não esperamos como escopo:
    ```
    * Fluxo de geração de cartão
    * Qualquer fluxo realizado após a aprovação ou reprovação da proposta
    ```
  
  - O que vamos avaliar:
    ```
    * Seu código; 
    * Organização;
    * Boas práticas;
    ```

### Instruções
        1. Faça o fork do desafio e crie uma branch 'desafio_analise_credito_nome_candidato';
        2. Desenvolva. Você terá 3 (três) dias a partir da data do envio do desafio; 
        3. Após concluir seu trabalho faça um push; 
        4. Crie um arquivo de texto com a nomenclatura README.MD com a explicação de como devemos executar o 
        projeto e com uma descrição do que foi feito; 
        5. Solicite o Merge request para o repositório original e que a força esteja com você.

>>>>>>> README.md
