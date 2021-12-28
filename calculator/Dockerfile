FROM openjdk:11
VOLUME /tmp
ADD ./target/calculator-0.0.1-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","/calculator.jar"]
EXPOSE 8081