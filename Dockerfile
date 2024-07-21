# Use the official Maven image to build the application
FROM maven:3.8.6-openjdk-17 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the Maven build files to the container
COPY pom.xml .
COPY src ./src

# Build the application, resulting in a WAR file
RUN mvn clean package -DskipTests

# Use the official Tomcat image as the base image for the runtime
FROM tomcat:9.0.65-jdk17

# Remove the default Tomcat webapps to ensure a clean deployment
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file from the build stage
COPY --from=build /app/target/flightManagementSystem-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application (Tomcat starts automatically)
CMD ["catalina.sh", "run"]
