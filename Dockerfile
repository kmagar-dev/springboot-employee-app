# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged .jar file from the local machine to the container
COPY target/Employee-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080
