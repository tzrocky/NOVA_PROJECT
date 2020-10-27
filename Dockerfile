# Build a JAR File
FROM maven:3.6.3-jdk-8-slim AS stage1
# Add Maintainer Info
LABEL maintainer="tzrocky@yahoo.fr"
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM openjdk:8-jdk-alpine
EXPOSE 5000
COPY --from=stage1 /home/app/target/novaschool-0.0.1-SNAPSHOT.jar novaschool.jar
ENTRYPOINT ["sh", "-c", "java -jar /novaschool.jar"]
