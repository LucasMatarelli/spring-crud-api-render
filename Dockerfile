# Estágio 1: Build (Construção com Maven)
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /workspace
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean install -DskipTests

# Estágio 2: Run (Execução)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Expõe a porta que o Spring usa
EXPOSE 8080 

# Copia o .jar que o 'builder' criou
COPY --from=builder /workspace/target/*.jar app.jar

# Comando final para rodar a API
ENTRYPOINT ["java", "-jar", "app.jar"]