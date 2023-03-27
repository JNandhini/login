FROM adoptopenjdk/openjdk8:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} login-0.0.1-SNAPSHOT.jar
EXPOSE 8090
CMD ["java","-jar","/login-0.0.1-SNAPSHOT.jar"]