FROM maven:3-jdk-8
WORKDIR /smartheating/
RUN git clone https://github.com/smartheating/ServiceRegistration.git
WORKDIR /smartheating/ServiceRegistration
RUN mvn clean install -DskipTests
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "target/ServiceRegistration-0.0.1-SNAPSHOT.jar"]
