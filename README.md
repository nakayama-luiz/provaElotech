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

### Livro

#### Persiste livro a partir de um livro fornecido pela integração.

```http
  POST api/livro/integracao/novo-livro
```
Exemplo de corpo:
```JSON
 
  "items": [{
			"volumeInfo": {
				"title": "O Mestre E Margarida.",
				"authors": [
					"Mikhail bulgakov."
				],
				"publishedDate": "2012-12-01",
				"categories": [
					"Literatura"
				],
				"industryIdentifiers": [
					{
						"type": "ISBN_13",
						"identifier": "9781234567897"
					},
					{
						"type": "ISBN_10",
						"identifier": "8468713481"
					}
				]
			}
		}]
}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `items`      | `items` | **Obrigatório**.
| `volumeInfo`      | `volumeInfo` | **Obrigatório**.
| `title`      | `string` |**Obrigatório**. Título do volume (livro) |
| `authors`      | `authors` |**Obrigatório**. Autores do livro |
| `publishedDate`      | `date` |**Obrigatório**. Data de publicação|
| `categories`      | `categories` |**Obrigatório**. Categorias do livro|
| `industryIdentifiers`      | `industryIdentifiers` |Tipos de ISBN.|
| `type`      | `type` |Tipos de ISBN (13, ou 10).|
| `identifier`      | `string` |**Obrigatório**. ISBN|

### Integração API Google Books

#### Recupera dados da apartir da API do Google Books, dada a query

```http
  GET api/integracao/search
```
Exemplo de requisição:

HOST/api/integracao/search?query=Viagem%20ao%20fim%20da%20noite

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `query`      | `string` | **Obrigatório**. Parametro de pesquisa da query.|

#### Altera dados do usuário dado o ID.

```http
  GET api/integracao/search
```
Exemplo de requisição:

HOST/api/integracao/titulo?titulo=Em busca do tempo Perdido

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `titulo`      | `string` | **Obrigatório**. Parametro de pesquisa para pesquisa pelo titulo|

