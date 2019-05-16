FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
ADD ./target/skillskompas-0.0.1-SNAPSHOT.jar sk-dbi-be.jar
CMD ["java", "-jar", "sk-dbi-be.jar"]
