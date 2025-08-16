📚 Biblioteca Spring Boot

Projeto simples de gerenciamento de Livros e Pessoas usando Java, Spring Boot, JPA e H2 (Ainda estudando SQL).
Esse projeto permite o cadastro de livros e pessoas, emprestar e devolver livros em um gerenciamento bem simples de biblioteca.



🚀 Tecnologias usadas
- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (em memória)
- Maven

⚙️ Como rodar o projeto
1. Clone o repositório:
   git clone <https://github.com/Omeyeer/biblioteca>
   cd biblioteca

2. Compile e rode:
   ./mvnw spring-boot:run

3. Acesse a aplicação em http://localhost:8080

4. Para acessar o H2 Console:
   http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:biblioteca
   - User: sa
   - Password: (deixar em branco)

📖 Endpoints da API

Livros
- GET    /livros                 → Lista todos os livros
- POST   /livros                 → Cadastra um novo livro
- PUT    /livros/emprestar/{id}  → Marca um livro como emprestado
- PUT    /livros/devolver/{id}   → Marca um livro como devolvido

Exemplo POST /livros
{
  "titulo": "Código Limpo",
  "autor": "Robert C. Martin",
  "totPaginas": 425,
  "emprestado": false
}

Pessoas
- GET    /pessoas                → Lista todas as pessoas
- POST   /pessoas                → Cadastra uma nova pessoa

Exemplo POST /pessoas
{
  "nome": "João Pedro",
}

⚠️ Observações
- O banco H2 é em memória, os dados somem ao desligar a aplicação.
- Todos os endpoints seguem o padrão RESTful.

👤 Autor
- Leonardo Cantarella
