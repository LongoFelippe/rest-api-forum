FROM openjdk:17
FROM maven:latest as builder

WORKDIR /app
COPY pom.xml /app
COPY src/ /app/src
RUN mvn clean install

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "./target/rest-api-forum-0.0.1-SNAPSHOT.jar"]