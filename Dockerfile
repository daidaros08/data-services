FROM openjdk:17-jdk-slim

WORKDIR /app

# Variables de entorno para configuración
ENV DEBUG="true"
ENV JAVA_OPTS=""
ENV JAVA_PARAM="-jar /app/app.jar"

# Copiar los archivos necesarios
COPY build/libs/data-service-0.0.1-SNAPSHOT.jar /app/app.jar
COPY docker-entrypoint.sh /docker-entrypoint.sh


# Exponer el puerto
EXPOSE 8080

# Definir permisos y el punto de entrada
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
