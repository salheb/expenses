FROM openjdk:17-oracle
MAINTAINER julionogueira.com

ARG JAR_FILE=application/target/application-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} expenses-backend-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar","/expenses-backend-1.0-SNAPSHOT.jar"]