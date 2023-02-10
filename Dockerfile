FROM openjdk:18-jdk-alpine

RUN mkdir /app
WORKDIR /app
COPY --from=build/libs/ /calculator-0.0.1-SNAPSHOT.jar backcalculator.jar
ENTRYPOINT ["java","-jar","backcalculator.jar"]
