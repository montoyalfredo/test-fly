FROM openjdk:18-jdk-alpine

RUN mkdir /app
WORKDIR /app
COPY --from=build/libs/  backcalculator.jar
ENTRYPOINT ["java","-jar","backcalculator.jar"]
#/calculator-0.0.1-SNAPSHOT.jar
