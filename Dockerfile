FROM java:8-jdk-alpine
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=target/ServiceRegistration-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} serviceregistration.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/serviceregistration.jar"]