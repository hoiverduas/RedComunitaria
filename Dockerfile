FROM eclipse-temurin:17.0.13_11-jdk

EXPOSE 8080

WORKDIR /root

COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# Otorgar permisos de ejecución a mvnw
RUN chmod +x /root/mvnw

# Descargar las dependencias
RUN ./mvnw dependency:go-offline

# Copiar el código fuente de la aplicación
COPY ./src /root/src

# Construir la aplicación
RUN ./mvnw package -DskipTests
# Levantar la aplicación
CMD ["java", "-jar", "/root/target/redComunitaria-0.0.1-SNAPSHOT.jar"]



