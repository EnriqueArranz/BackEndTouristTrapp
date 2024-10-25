# Usa una imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR que genera Maven/Gradle en el contenedor
COPY target/Tourist_Trapp-0.0.1-SNAPSHOT.jar /app/Tourist_Trapp-0.0.1-SNAPSHOT.jar

# Expone el puerto que tu aplicación utilizará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/Tourist_Trapp-0.0.1-SNAPSHOT.jar"]