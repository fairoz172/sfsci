FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME /tmp
ADD /target/sfsci-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]
