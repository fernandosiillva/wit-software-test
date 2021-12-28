FROM openjdk:11
ADD ./target/api-operation-0.0.1-SNAPSHOT.jar api-operation.jar
ENTRYPOINT ["java","-jar","/api-operation.jar"]
EXPOSE 8080