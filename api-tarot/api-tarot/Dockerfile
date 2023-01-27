# Faz o build
FROM maven:3.8-openjdk as build

WORKDIR /build

COPY . .

RUN mvn clean package --quiet

# Final app
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
