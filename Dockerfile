# Use Eclipse Temurin OpenJDK 21 base image
FROM eclipse-temurin:21-jdk
# Set working directory
WORKDIR /app
# Copy the JAR file
COPY target/docker-demo-0.0.1-SNAPSHOT.jar docker-demo-0.0.1-SNAPSHOT.jar
# Expose port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "docker-demo-0.0.1-SNAPSHOT.jar"]
