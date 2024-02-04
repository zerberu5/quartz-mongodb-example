# Use an OpenJDK image with Oracle Linux
FROM openjdk:17-oracle

# Create a directory to store the JAR file
RUN mkdir /app

# Copy the JAR file to the container
COPY target/quartzer-*.jar /app/quartzer.jar

# Set the working directory
WORKDIR /app

# Run the JAR file
CMD ["java", "-jar", "/app/quartzer.jar"]
