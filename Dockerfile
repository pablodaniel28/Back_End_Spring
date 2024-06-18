# Usar una imagen base de Java 21 en Alpine Linux
FROM adoptopenjdk/openjdk17:alpine-jre

# Establecer un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR construido en la etapa anterior al contenedor
COPY target/*.jar app.jar

# Definir el comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
ENTRYPOINT ["java","-jar","app.jar"]

# Opcional: Exponer el puerto 8080 para permitir conexiones externas (puede no ser necesario)
EXPOSE 8080
