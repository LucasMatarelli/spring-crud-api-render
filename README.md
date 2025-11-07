# Projeto: API de CRUD com Spring Boot, JPA e Swagger

Este projeto é uma API REST completa desenvolvida em Spring Boot para gerenciar Documentos e Categorias, demonstrando um relacionamento `@ManyToOne`. A API implementa operações CRUD completas para ambas as entidades e utiliza Spring Data JPA para persistência de dados.

## Link da Aplicação no Render

A aplicação está hospedada no Render e pode ser acessada através do link:

**[https://spring-crud-api-render.onrender.com](https://spring-crud-api-render.onrender.com)**

*(Este link só funcionará após o deploy no Render ser concluído com sucesso)*

## Documentação da API (Swagger)

A documentação de todos os endpoints da API está disponível e é gerada automaticamente pelo Swagger (via SpringDoc).

**Link da Documentação: [https://spring-crud-api-render.onrender.com/swagger-ui.html](https://spring-crud-api-render.onrender.com/swagger-ui.html)**

### 🗒 Como usar o Swagger

1.  Acesse o link da documentação acima.
2.  Você verá uma lista de "Controllers" (ex: `categoria-controller`, `documento-controller`).
3.  Clique em um endpoint para expandir.
4.  Clique em "**Try it out**" para habilitar os campos.
5.  Preencha o corpo da requisição (`Request body`) se necessário (ex: para criar uma categoria).
6.  Clique em "**Execute**".

O Swagger mostrará a resposta do servidor (Response), o código (ex: 200 OK) e o `curl` da requisição.

**Tutorial Oficial do Swagger:** [https://swagger.io/docs/](https://swagger.io/docs/)

## Passos para Execução Local

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/LucasMatarelli/spring-crud-api-render.git](https://github.com/LucasMatarelli/spring-crud-api-render.git)
    cd spring-crud-api-render
    ```

2.  **Execute a aplicação (usando Maven Wrapper):**
    ```bash
    ./mvnw spring-boot:run
    ```

3.  **Acesse os serviços:**
    * **API:** [http://localhost:8080/api/categorias](http://localhost:8080/api/categorias)
    * **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    * **Banco H2 (em memória):** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
        * (JDBC URL: `jdbc:h2:mem:testdb`, User: `sa`, Password: *deixe em branco*)

## Vídeos de Apoio

* **Configuração do Swagger:** [http://youtube.com/watch?v=7x88AlD3Iv8](http://youtube.com/watch?v=7x88AlD3Iv8)
* **Deploy no Render:** [https://www.youtube.com/watch?v=fwWvgk_SW2g](https://www.youtube.com/watch?v=fwWvgk_SW2g)
