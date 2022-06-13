FROM  openjdk:11
EXPOSE 8083
ADD /target/candidate-service-0.0.1-SNAPSHOT.jar candidate-service.jar
ENTRYPOINT ["java", "-jar", "candidate-service.jar"]