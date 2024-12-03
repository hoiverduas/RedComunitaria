#IMAGEN MODELO
FROM eclipse-temurin:17.0.13_11-jdk
#INFORMAR EL PUETO DONDE SE EJECUTA EL CONTGENEDOR(INFORMATIVO)
EXPOSE 8080

#DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root
#COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root
#DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline
#COPIAMOS EL CODIGO FUENTE DENRO EL CONTENEDOR
COPY ./src /root/src
#CONTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests
#LEVANTA NUESTRA APLICACION CUANDO NUESTRO CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/target/redComunitaria-0.0.4-SNAPSHOT.jar"]


