FROM openjdk:8-jre-alpine

MAINTAINER Tempranillo
#RUN apt update && apt install -y ca-certificates

WORKDIR /app
EXPOSE 8080
RUN echo "'Copy jar'"
ADD /target/sk-dbi-be-0.0.1-SNAPSHOT.jar sk-dbi-be.jar
RUN echo "'Done copying jar'"


USER 997

CMD ["java", "-jar", "sk-dbi-be.jar"]

