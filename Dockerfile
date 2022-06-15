FROM  openjdk:8
EXPOSE 8083
ADD /target/candidate-service-1.0.0-snapshot.jar candidate-service.jar
ENTRYPOINT ["java", "-jar", "candidate-service.jar"]