FROM java:8

ADD ./target/equation-1.0-SNAPSHOT.jar /app.jar

EXPOSE 8080

CMD java -jar /app.jar
