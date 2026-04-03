FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# Give permission to mvnw
RUN chmod +x mvnw

# Build jar file
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Run jar automatically
CMD ["sh", "-c", "java -jar target/*.jar"]