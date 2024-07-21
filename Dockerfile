# Stage 1: Build the application
# Use Maven with Java 17 for building the application
FROM maven:3.8.4-openjdk-17 as build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Maven configuration file and source code
COPY pom.xml ./
COPY src ./src

# Build the application using Maven, skipping tests to speed up the build
RUN mvn package -DskipTests

# Stage 2: Create the runtime image
# Use Tomcat with OpenJDK 17 as the base image
FROM tomcat:9.0-jdk17-openjdk-slim

# Remove default web applications deployed in Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the build stage to the Tomcat webapps directory
COPY --from=build /app/target/flightManagementSystem-*.war /usr/local/tomcat/webapps/ROOT.war

# Tomcat exposes port 8080
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]