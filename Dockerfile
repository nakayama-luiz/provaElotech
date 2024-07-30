FROM openjdk:17-jdk-alpine
FROM gradle:7.2.0-jdk17-alpine AS buildar

WORKDIR /home/gradle/project
COPY . .
RUN gradle build



WORKDIR /app

COPY --from=buildar /home/gradle/project/build/libs/biblioteca-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
