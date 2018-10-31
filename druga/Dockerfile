FROM openjdk:11-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/druga-api-1.0-SNAPSHOT.jar /app

EXPOSE 8090

CMD java -jar druga-api-1.0-SNAPSHOT.jar