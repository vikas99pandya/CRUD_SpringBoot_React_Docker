FROM openjdk:11
VOLUME /tmp
ADD   /target/docker_backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Xmx750m", "-jar","/app.jar"]