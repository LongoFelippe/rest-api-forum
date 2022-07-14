# Sobre!

> REST API em `Kotlin` com `Java 17` e `Spring Framework`


**Executando a aplicação com Docker**
* _Na pasta do projeto digite o seguintes comandos:_
```dockerfile
   docker build -t forum-rest-api .
   docker run -it --entrypoint sh forum-rest-api
   
   ##Execute o jar dentro do container Docker.
   > java -jar ./target/rest-api-forum-0.0.1-SNAPSHOT.jar
```