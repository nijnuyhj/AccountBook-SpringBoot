FROM openjdk:17
COPY build/libs/accountbook-0.0.1-SNAPSHOT-plain.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
