FROM openjdk:8-jdk-alpine

LABEL maintainer="Luan Roger Santos Santana"

VOLUME /temp

EXPOSE 8080

ARG JAR_FILE=target/Mr_Xavier-0.1.0.jar

ADD ${JAR_FILE} Mr_Xavier.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Mr_Xavier.jar"
