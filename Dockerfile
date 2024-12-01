FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/redComunitaria-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app-redComunitaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-redComunitaria.jar"]