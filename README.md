# Grade API

## :pushpin: Conteúdo

- [Sobre](#Sobre)
- [Tecnologias](#Tecnologias)
- [Modelagem](#Modelagem)
- [Como executar o projeto](#Como-executar)
- [Endpoints](#Endpoints)

---

<a name="Sobre"></a>
## :book: Sobre

A **Grade API** faz parte de um sistema maior chamado [schedule-api](https://github.com/reetz-dev/schedule-api), permitindo a gestão de grades horárias escolares. O objetivo é possibilitar a criação, edição e remoção de dias da semana e horários em uma determinada grade.

---

<a name="Tecnologias"></a>
## :computer: Tecnologias

### Backend

* [Java](https://www.java.com/pt-BR/) (OpenJDK 17)
- [Spring Boot](https://spring.io/projects/spring-boot/)
- Spring Data JPA
- PostgreSQL
- Lombok
- Docker

---

## 🧠 Modelagem

A entidade principal é a `Grade`, com os seguintes campos:

- `id`: Identificador único da grade
- `name`: Nome da grade
- `weekdays`: Lista de dias da semana
- `horarios`: Lista de horários

---

## ▶️ Como executar

Para rodar a API localmente:

```shell
$ git clone https://github.com/reetz-dev/grade-api.git
$ cd grade-api

#Caso use o docker

$ docker compose up -d
```
Para rodar ele no terminal:

```shell
$ cd grade-api
$ ./mvnw spring-boot:run
```

Grade API estará acessível em `http://localhost:3002`

<a name="Enums"></a>
## :paperclip: Enums

<details>
  <summary>
    <strong>Weekdays</strong>
  </summary>

```
    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA;
```

  </details>

<details>
  <summary>
    <strong>Weekdays</strong>
  </summary>

```
    PRIMEIRA_AULA,
    SEGUNDA_AULA,
    TERCEIRA_AULA,
    QUARTA_AULA,
    QUINTA_AULA;
```

  </details>


<a name="Endpoints"></a>
## :paperclip: Endpoints

<details>
  <summary>
    <strong>Get</strong>
  </summary>
  
#### Retorna todas as matérias

```http
  GET http://localhost:3002/api/grades
```
##### Exemplo de resposta:
```json
[
	{
		"id": 1,
		"name": "Filosofia",
		"weekdays": [
			"QUARTA_FEIRA"
		],
		"horarios": [
			"PRIMEIRA_AULA"
		]
	}
```

#### Buscar Matéria por Id

```http
  GET http://localhost:3002/api/grades/4
```
##### Exemplo de resposta:
```json
{
	"id": 4,
	"name": "Artes",
	"weekdays": [
		"QUARTA_FEIRA"
	],
	"horarios": [
		"TERCEIRA_AULA"
	]
}
```

#### Buscar dias da semana de uma matéria

```http
  GET http://localhost:3002/api/grades/weekdays/2
```
##### Exemplo de resposta:
```json
{
	"id": 2,
	"name": "Sociologia",
	"weekdays": [
		"SEGUNDA_FEIRA",
		"QUINTA_FEIRA"
	],
	"horarios": [
		"PRIMEIRA_AULA",
		"SEGUNDA_AULA"
	]
}
```

#### Buscar todas matérias por semana

```http
  GET http://localhost:3002/api/grades/weekdays
```
##### Exemplo de resposta:
```json
[
	{
		"id": 1,
		"name": "Filosofia",
		"weekdays": [
			"TERCA_FEIRA"
		],
		"horarios": [
			"PRIMEIRA_AULA"
		]
	},
	{
		"id": 2,
		"name": "Sociologia",
		"weekdays": [
			"SEGUNDA_FEIRA",
			"QUINTA_FEIRA"
		],
		"horarios": [
			"PRIMEIRA_AULA",
			"SEGUNDA_AULA"
		]
	},
	{
		"id": 4,
		"name": "Artes",
		"weekdays": [
			"QUARTA_FEIRA"
		],
		"horarios": [
			"TERCEIRA_AULA"
		]
	}
]
```

</details>

<details>
  <summary>
    <strong>Post</strong>
  </summary>

#### Cadastro de matérias

```http
  POST http://localhost:3002/api/grades
```

##### Cadastrar uma Matéria:
| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | **Obrigatório**. Nome da matéria |

##### Exemplo de criação de um cliente:
```json
{
    "name": "Artes"
}
```

##### Exemplo de resposta:
```json
{
	"id": 4,
	"name": "Artes",
	"weekdays": null,
	"horarios": null
}
```


#### Cadastrar dia da semana pelo Id

```http
  POST http://localhost:3002/api/grades/weekdays
```

##### Corpo da requisição:
| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `gradeId` | `long` | **Obrigatório**. Id da matéria |
| `weekday` | `enum` | **Obrigatório**. Weekday da matéria |

##### Exemplo de criação de uma matéria:
```json
{
	"gradeId":4,
	"weekday": "QUARTA_FEIRA"
}
```

##### Exemplo de resposta:
```json
{
	"id": 4,
	"name": "Artes",
	"weekdays": [
		"QUARTA_FEIRA"
	],
	"horarios": []
}
```



#### Cadastrar horário em uma matéria

```http
  POST http://localhost:3002/api/grades/times
```

##### Corpo da requisição:
| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `gradeId` | `long` | **Obrigatório**. Id da matéria |
| `time` | `enum` | **Obrigatório**. Time da matéria |

##### Exemplo de criação de uma matéria:
```json
{
	"gradeId": 4,
	"time":"TERCEIRA_AULA"
}
```

##### Exemplo de resposta:
```json
{
	"id": 4,
	"name": "Artes",
	"weekdays": [
		"QUARTA_FEIRA"
	],
	"horarios": [
		"TERCEIRA_AULA"
	]
}
```

</details>

<details>
  <summary>
    <strong>PUT</strong>
  </summary>
  
#### Atualiza dia da semana da matéria

```http
  http://localhost:3002/api/grades/weekdays/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. Identificação do cliente |

##### Exemplo de requisição:
```http
  PUT http://localhost:3002/api/grades/weekdays/1
```

##### Corpo da requisição:
| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `oldWeekday` | `string` | **Obrigatório**. Antigo dia da semana |
| `newWeekday` | `string` | **Obrigatório**. Novo dia da semana |

##### Exemplo de requisição:
```json
{
  "oldWeekday": "QUARTA_FEIRA",
  "newWeekday": "TERCA_FEIRA"
}
```

##### Exemplo de resposta:
```json
{
	"id": 1,
	"name": "Filosofia",
	"weekdays": [
		"TERCA_FEIRA"
	],
	"horarios": [
		"PRIMEIRA_AULA"
	]
}
```

#### Atualizar horário da matéria

```http
  PUT http://localhost:3002/api/grades/times/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `long` | **Obrigatório**. Identificação do cliente |

##### Exemplo de requisição:
```http
  http://localhost:3002/api/grades/times/2
```

##### Corpo da requisição:
| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `gradeId` | `string` | *Opcional*. Identificação do cliente |
| `oldTime` | `string` | **Obrigatório**. Antigo Horário |
| `newTime` | `string` | **Obrigatório**. Novo Horário |

##### Exemplo de requisição:
```json
{
	"gradeId":2,
	"oldTime": "TERCEIRA_AULA",
	"newTime": "PRIMEIRA_AULA"
}
```

##### Exemplo de resposta:
```json
{
	"id": 2,
	"name": "Sociologia",
	"weekdays": [
		"SEGUNDA_FEIRA",
		"QUINTA_FEIRA"
	],
	"horarios": [
		"SEGUNDA_AULA",
		"PRIMEIRA_AULA"
	]
}
```

</details>

<details>
  <summary>
    <strong>DELETE</strong>
  </summary>

#### Inativa uma matéria

```http
  DELETE http://localhost:3002/api/grades/{id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | **Obrigatório**. Identificação do cliente |

##### Exemplo de requisição:
```http
  DELETE http://localhost:3002/api/grades/1
```


  
#### Tira o Dia da semana de uma Matéria

```http
  DELETE http://localhost:3002/api/grades/weekdays/{id}/{weekday}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | **Obrigatório**. Identificação do cliente |
| `weekday` | `enum` | **Obrigatório**. Identificação do dia da semana |

##### Exemplo de requisição:
```http
  DELETE http://localhost:3002/api/grades/weekdays/1/SEGUNDA_FEIRA
```
  


#### Tira o Horário de uma Matéria

```http
  DELETE http://localhost:3002/api/grades/times/{id}/{time}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id` | `string` | **Obrigatório**. Identificação do cliente |
| `time` | `enum` | **Obrigatório**. Identificação do horário |

##### Exemplo de requisição:
```http
  DELETE http://localhost:3002/api/grades/times/1/PRIMEIRA_AULA
```
  

</details>
