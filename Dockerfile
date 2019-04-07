FROM openjdk:8

COPY fibonacci-rest-1.0-SNAPSHOT.jar fibonacci-rest.jar

CMD java -jar fibonacci-rest.jar

EXPOSE 7003