FROM eclipse-temurin:21-jre-alpine

LABEL MAINTAINER="Mauricio Generoso"

RUN mkdir /apps

COPY build/libs/service-discovery.jar /apps/service-discovery.jar

RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

ENTRYPOINT exec java -jar /apps/service-discovery.jar
