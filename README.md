# 📚 Biblioteca RESTful

Uma aplicação backend em **Java + Spring Boot** que gerencia livros de uma biblioteca.
Todos os endpoints seguem o padrão **REST** e retornam **JSON**.

---

## 🔹 Tecnologias

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 Database 
* Maven
* IDE: IntelliJ

---

## 🔹 Funcionalidades

* Listar todos os livros (`GET /api/livros`)
* Criar novo livro (`POST /api/livros`)
* Emprestar um livro (`POST /api/livros/{id}/emprestar`)
* Devolver um livro (`POST /api/livros/{id}/devolver`)

---

## 🔹 Endpoints

### Listar livros

```
GET /api/livros
```

**Retorno exemplo:**

```json
[
  {
    "id": 1,
    "titulo": "Código Limpo",
    "autor": "Robert C. Martin",
    "totpaginas": "425",
  },
  {
    "id": 2,
    "titulo": "Entendendo Algoritimos",
    "autor": "Aditya Y. Bhargava",
    "totpaginas": "264",
  }
]
```

### Criar livro

```
POST /api/livros
```

**Corpo (JSON):**

```json
{
    "titulo": "Arquitetura Limpo",
    "autor": "Robert C. Martin",
    "totpaginas": "432",
}
```

**Retorno:**

```json
{
  "id": 3,
   "titulo": "Arquitetura Limpo",
    "autor": "Robert C. Martin",
    "totpaginas": "432",
  "emprestado": false
}
```

### Emprestar livro

```
POST /api/livros/{id}/emprestar
```

**Exemplo:**

```
POST /api/livros/1/emprestar
```

**Retorno:**

```json
"Livro emprestado com sucesso!"
```

### Devolver livro

```
POST /api/livros/{id}/devolver
```

**Exemplo:**

```
POST /api/livros/1/devolver
```

**Retorno:**

```json
"Livro devolvido com sucesso!"
```

---

## 🔹 Estrutura do projeto

```
biblioteca-rest/
├── src/main/java/com/estudos/biblioteca
│   ├── controller
│   │   └── LivroController.java
│   ├── model
│   │   └── Livro.java
│   ├── repository
│   │   └── LivroRepository.java
│   └── service
│       └── LivroService.java
├── src/main/resources
│   └── application.properties
└── pom.xml
```
(Classe pessoa ainda em implementação)

---

## 🔹 Como rodar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/biblioteca-rest.git
cd biblioteca-rest
```

2. Compile e rode a aplicação:

```bash
mvn spring-boot:run
```

3. Teste os endpoints com **Postman**, **Insomnia** ou **curl**.

---

## 🔹 Observações

* Todos os endpoints retornam **JSON**.
* Regras de negócio (emprestar e devolver) estão no **LivroService**.
