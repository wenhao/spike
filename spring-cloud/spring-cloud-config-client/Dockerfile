FROM openjdk:8

VOLUME /tmp
ADD ./build/*.jar /opt/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]