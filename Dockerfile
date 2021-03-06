FROM maven:3.6.3-jdk-11-slim AS builder
WORKDIR /store
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
COPY src ./src
RUN ls -la ./src
RUN mvn clean package
RUN ls -la /store


FROM openjdk:11.0.6-jdk
LABEL maintainer="alonsofisi@gmail.com"
WORKDIR /workspace
RUN ls -la /workspace
COPY --from=builder /store/target/app*venta*.jar app.jar
RUN ls -la /workspace
ENTRYPOINT exec java -jar /workspace/app.jar
EXPOSE 2050

