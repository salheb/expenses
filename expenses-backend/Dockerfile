FROM openjdk:17-oracle

ARG JAR_FILE=configuration/target/configuration-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} expenses-backend.jar

ENTRYPOINT ["java", "-jar","expenses-backend.jar","com.julio.expensesapp.Application"]