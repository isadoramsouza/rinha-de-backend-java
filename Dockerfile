FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/rinha-de-backend-java-0.0.1-SNAPSHOT.jar ./rinha-backend.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "./rinha-backend.jar" ]