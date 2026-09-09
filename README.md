# Projeto_individual_3semestre
Repositório para projeto individual da faculdade 3 semestre

Adoção de Pets

Sistema para cadastro e consulta de pets para adoção.

Como executar:

Back-end:

Abra o projeto Java no IntelliJ.
Execute a classe ProjetoPetsApplication.
O servidor será iniciado em:
http://localhost:8080

Front-end:

Abra o arquivo Projeto_pets.html utilizando o Live Server.

O back-end deve estar executando para o sistema funcionar.

Comunicação com a API:

O front-end utiliza fetch() para se comunicar com a API

GET /pets → lista os pets e preenche o select.

POST /pets → cadastra um novo pet.

GET /pets/{id} → consulta um pet pelo ID.

A API utiliza Java, Spring Boot, JdbcTemplate e banco de dados H2.
O front utiliza Html, Javascript e css.
