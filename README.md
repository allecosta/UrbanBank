# UrbanBank

*Conectando a modernidade das cidades com o mundo financeiro.*

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

- Acessar o H2 via browser: http://localhost:8080/h2-console/
- Testar API via Swagger: http://localhost:8080/swagger-ui/index.html