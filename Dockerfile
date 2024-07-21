# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build files to the container
COPY ./pom.xml ./pom.xml
COPY ./src ./src

# Install Maven and build the application
RUN apk add --no-cache maven && \
    mvn -B -f pom.xml clean package

# Copy the built JAR file to the container
COPY target/flight-management-system-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]
