# Etapa 1: Compilar la aplicación
FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Instalar utilidades útiles
RUN apk add --no-cache \
    curl \
    wget \
    htop \
    ps \
    netstat \
    net-tools \
    lsof \
    iputils-ping \
    bash

COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080

# Health check usando Spring Boot Actuator
HEALTHCHECK --interval=30s --timeout=10s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]