FROM openjdk:17-jdk-alpine
COPY target/ChatApp-0.0.1-SNAPSHOT.jar ChatApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/ChatApp-0.0.1-SNAPSHOT.jar" ]