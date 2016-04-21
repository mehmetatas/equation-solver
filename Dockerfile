FROM mehmetatas/docker-maven

COPY ./pom.xml ./project/pom.xml
COPY ./src ./project/src

RUN cd project && \
	mvn package -Dmaven.test.skip=true && \
	cd .. && \
	mv ./project/target/equation-1.0-SNAPSHOT.jar ./app.jar && \
	rm -rf ./project

EXPOSE 8080

CMD java -jar ./app.jar