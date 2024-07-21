# Use an official Maven image with Java 11 as the base image
FROM maven:3.8.4-openjdk-11 as build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Maven wrapper and pom.xml file
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Ensure mvnw is executable
RUN chmod +x mvnw

# Copy the source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# For the final image, use an OpenJDK image
FROM openjdk:11-jre-slim

# Copy the built application from the build image
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
CMD ["java", "-jar", "/app.jar"]