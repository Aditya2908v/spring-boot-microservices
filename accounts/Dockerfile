#Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

MAINTAINER "aditya.sureshkumarreddy.ciec@skytv.it"

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]