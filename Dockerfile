FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar demo.jar
EXPOSE 7000
CMD ["java", "-jar", "demo.jar"]

