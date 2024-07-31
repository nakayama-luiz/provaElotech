FROM gradle:8.7.0-jdk17-alpine AS build

WORKDIR /home/gradle/project

COPY . .

RUN gradle build -x test

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /home/gradle/project/build/libs/biblioteca-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]