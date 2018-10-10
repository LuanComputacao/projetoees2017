FROM openjdk:8-jdk-alpine

LABEL maintainer="Luan Roger Santos Santana"

LABEL description="Mr Xavier maven npm"

RUN /bin/echo "Mr Xavier foi" && \
    apk update && \
    apk add maven && \
    apk add npm && \
    npm install -g npm && \
    apk add screen

VOLUME /var/wwww/
WORKDIR /var/www/

EXPOSE 8080

ARG JAR_FILE=target/Mr_Xavier-0.1.0.jar

ADD ${JAR_FILE} Mr_Xavier.jar

