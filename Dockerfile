# Use a imagem base com o Java e o Maven instalados
FROM maven:3.8.4-openjdk-17-slim AS builder

# Configurar diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo pom.xml para o contêiner
COPY pom.xml .

# Baixar as dependências do Maven
RUN mvn dependency:go-offline -B

# Copiar o restante do código-fonte para o contêiner
COPY src ./src

# Compilar o projeto
RUN mvn package -DskipTests

# Usar uma imagem base do Java para executar o aplicativo
FROM openjdk:17-slim

# Configurar diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo JAR construído na etapa anterior
COPY --from=builder /app/target/ecommerce-0.0.1-SNAPSHOT.jar .

# Executar a aplicação Java
CMD ["java", "-jar", "ecommerce-0.0.1-SNAPSHOT.jar"]
