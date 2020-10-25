FROM alpine/git as clone 
WORKDIR /
RUN git clone https://github.com/tzrocky/nova_project.git

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /
COPY --from=clone /nova_project / 
RUN mvn clean install



# Start with a base image containing Java runtime
FROM java:8
#openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="tzrocky@yahoo.fr"

# Add a volume pointing to /tmp
WORKDIR /
#VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
#ARG JAR_FILE=novaschool.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} novaschool.jar
#ADD novaschool.jar  novaschool.jar

# Run the jar file 
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/novaschool-0.0.1-SNAPSHOT.jar"]
CMD java - jar novaschool.jar
