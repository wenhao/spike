FROM openjdk:8

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
