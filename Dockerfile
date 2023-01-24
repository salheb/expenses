FROM java
MAINTAINER Julio Nogueira - www.julionogueira.com <julio.salheb@gmail.com>

ARG JAVA_PACKAGE=java-17-openjdk-headless
ARG RUN_JAVA_VERSION=1.3.8
ARG FLIWAY_VERSION=7.5.2

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/musa/expenses-backend.jar
#COPY ${JAR_FILE} expenses-backend-1.0-SNAPSHOT.jar

#ENTRYPOINT ["java", "-jar","/expenses-backend-1.0-SNAPSHOT.jar"]