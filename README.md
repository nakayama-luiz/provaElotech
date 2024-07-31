# Desafio Programador OXY

Projeto realizado para o teste prático para a vaga de desenvoledor OXY.


## Deploy

Para realizar o deploy da aplicação, é preciso criar o arquivo de configuração, o qual mantém a api key do Google Books.

O arquivo deve ser criado na pasta src/main/resources/ com o nome *application.production.properties*, contendo o conteúdo como se segue

```application.production.properties
api.key=<chave-da-api>
```

Como isso, retorne a raiz do projeto e inicie o *container* com:

```bash
docker-compose up -d
```

## Documentação da API

A documentação também é acessível através do swagger:

/swagger-ui/index.html#/

As rotas estão identificadas pelas *entidade*-*controller*. Por exemplo, *livro-controller*.

### Usuário

#### Retorna um usuário por id

```http
  GET /api/usuario/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. O ID do usuário desejado |

#### Persiste um usuário na base de dados.

```http
  POST /api/usuario
```
Exemplo de corpo:
```json
 {
  "nome": "Pedro",
  "email": "pedro@gmail.com",
  "telefone": "44998435710"
}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. Nome do usuário|
| `email`      | `string` | **Obrigatório**. **Único**. |
| `telefone`      | `string` | telefone do usuário |

#### Altera dados do usuário dado o ID.

```http
  PUT /api/usuario
```
Exemplo de corpo:
```json
 {
"id": 1,
  "nome": "Pedro",
  "email": "pedro1@gmail.com",
  "telefone": "44998435710"
}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. Id do usuário|
| `nome`      | `string` | **Obrigatório**. Nome do usuário|
| `email`      | `string` | **Obrigatório**. **Único**. |
| `telefone`      | `string` | telefone do usuário |


#### Deleta o usuário dado seu id

```http
  DELETE /api/usuario/${id}
```


| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. Id do usuário|

### Integração Google Books

