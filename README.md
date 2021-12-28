# Calculator test project
### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Docker](https://www.docker.com/), [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html).

```bash
# Clone este repositório
$ git clone git@github.com:fernandosiillva/wit-software-test.git

# Acesse a pasta do projeto no terminal/cmd
$ cd wit-software-test

# Vá para a pasta api-operation
$ cd api-operation

# Instale as dependências
$ mvnw clean package

# Volte para a pasta wit-software-test
$ cd ..

# Vá para a pasta calculator
$ cd calculator

# Instale as dependências
$ mvnw clean package

# Volte para a pasta wit-software-test
$ cd ..

# Execute as aplicações utilizando o docker-compose
$ docker-compose up --build

# O servidor inciará na porta:8080 - execute o curl abaixo para teste
$ curl -H "Content-Type: application/json" -X GET "http://localhost:8080/sum?a=1&b=3"
```

Para saber mais sobre os path's da api, acesse a doc [Swagger](http://localhost:8080/swagger-ui.html).
