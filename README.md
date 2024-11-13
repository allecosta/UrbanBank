# UrbanBank

*Conectando a modernidade das cidades com o mundo financeiro.*

UrbanBank é uma RESTful API desenvolvida como trabalho de conclusão de curso para Java Spring Boot Claro,
realizada pela Digital Innovation One.

## Diagrama de classes do APP

```mermaid
classDiagram
    class User {
        - String name
        - Account account
        - Feature[] features
        - Card card
        - News[] news
    }
    
    class Account {
        - String number
        - String agency
        - double balance
        - double limit
    }

    class Feature {
        - String icon
        - String description
    }

    class Card {
        - String number
        - double limit
    }

    class News {
        - String icon
        - String description
    }

    User "1" --> "1" Account
    User "1" --> "1..*" Feature
    User "1" --> "1" Card
    User "1" --> "1..*" News

```

## Rodando o APP

Clone o projeto

```bash
  git clone https://github.com/allecosta/UrbanBank.git
```

Entre no diretório do projeto

```bash
  cd UrbanBank
```
Inicie o servidor

```bash
  Run Application Dev (ou shift+F10 no intellij)
```
- Após upar o servidor acesse: http://localhost:8080/swagger-ui/index.html

![Swagger](/assets/img/swagger.png)

- Para acessar o H2 e realizar testes: http://localhost:8080/h2-console/


## Tecnologias

- **Java 21:** Utilizei a versão mais recente do Java para tirar vantagem das últimas inovações;
- **Spring Boot 3:** Para maximiza a produtividade por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA (com o H2 para dados em memória):** Com essa ferramenta simplificamos nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger):** Documentação e testes da API de forma eficaz e fácil de entender, perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **PostgresSQL:** Para testes de persitência de dados em produção;
- **Gradle:** Como ferramenta de build.