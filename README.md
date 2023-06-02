E-commerce
Este é um projeto de e-commerce desenvolvido como parte de um desafio técnico utilizando o Spring Boot e o banco de dados H2. O projeto possui testes unitários para os principais métodos, assim como testes de integração.

Pré-requisitos
JDK 17
Maven
Instalação
Clone o repositório:
git clone `https://github.com/MichelLobato/siteware.git`

1. Entre no diretório do projeto:
`cd ecommerce`

2. Compile e empacote o projeto:
`mvn clean package`

3. Configuração do Banco de Dados
O projeto utiliza o banco de dados PostgreSQL. Antes de executar a aplicação, é necessário configurar as informações de conexão com o banco de dados. Por padrão, o projeto está configurado para usar um banco de dados H2 em memória para facilitar o desenvolvimento e os testes. Existem dois perfis de configuração disponíveis:

`application-dev.properties: Configurações para o banco de dados PostgreSQL.`
`application-test.properties: Configurações para o banco de dados H2.`
Certifique-se de atualizar as propriedades adequadas no arquivo de configuração correspondente ao perfil que você deseja utilizar.

4. Uso
Execute o seguinte comando para iniciar a aplicação:
`mvn spring-boot:run`

A aplicação estará disponível em http://localhost:8080.

5. Testes
Para executar os testes automatizados, utilize o seguinte comando:
`mvn test`
