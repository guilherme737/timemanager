# Timemanager - Time Manager 

## Pré-requisitos libs e versões utilizadas

- Java 11
- Springboot 2.x
- Spring Data
- Spring Security (com OAuth2)
- Hibernate 5.x
- Conexão com PostgreSQL

Backend criado para ser utilizado em conjunto com o projeto frontend [Time Manager](https://github.com/guilherme737/timemanager-app) 

## Sequência de instalação e execução do projeto

Utilizando a IDE de sua preferência faça o `import` como um `gradle project` se houver essa opção.

### Instalar dependencias
No diretório do projeto executar o comando (Linux ou Power Shell do Windows) 
```sh
$ ./gradlew build 
```
Opcionalmente pode ainda executar
```sh
$ ./gradlew build --refresh-dependencies
```

### Arquivo `application.yaml`
Na pasta `src/main/resources` edite o arquivo substituindo com as informações de conexão com o seu banco de dados de preferência e também as informações `#JWT properties` relativas a chave de autenticação para clientes permitidos à acessar os endpoints da aplicação. 

### Executando o projeto
Dentro do diretório raiz do projeto execute

```sh
$ ./gradlew bootRun
```

Ou utilize o mecanismo disponibilizado na IDE que estiver utilizando.
