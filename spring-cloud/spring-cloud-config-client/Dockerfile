FROM openjdk:8-alpine

VOLUME /tmp
ADD ./build/libs/*.jar /opt/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]