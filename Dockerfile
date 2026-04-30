# Replace maven:3.8.4-openjdk-17 with:
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Replace openjdk:17-jdk-slim with:
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY  --from=build /app/target/dms-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/dms-0.0.1-SNAPSHOT.jar"]