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

Consulta dos pets:

Quando a página é carregada, o JavaScript realiza uma requisição:

GET http://localhost:8080/pets

A API retorna uma lista de pets em formato JSON.

O JavaScript utiliza essa lista para preencher dinamicamente o campo de pets disponíveis.

Exemplo de resposta:

```json
{
    "id": 1,
    "nome": "Rex",
    "peso": 3,
    "dataNascimento": "2023-05-10",
    "sexo": "Macho"
}
```

Cadastro de um pet:

Ao clicar no botão **Cadastrar Pet**, o JavaScript valida os dados preenchidos e envia uma requisição:

```text
POST http://localhost:8080/pets
```

Os dados são enviados no corpo da requisição em formato JSON.

Exemplo:

```json
{
    "nome": "Rex",
    "peso": 3,
    "dataNascimento": "2023-05-10",
    "sexo": "Macho"
}
```

O servidor valida os dados novamente antes de realizar o cadastro no banco.

Quando o cadastro é realizado com sucesso, a API retorna:

```text
201 Created
```

Depois disso, o front-end limpa o formulário e realiza novamente o GET /pets para atualizar o campo de seleção.

A API utiliza Java, Spring Boot, JdbcTemplate e banco de dados H2.

O front-end utiliza HTML, JavaScript e CSS.

