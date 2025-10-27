#JDK as parent image
FROM openjdk:21-jdk-slim
#Workdir inside container
WORKDIR /app
#Copy the compiled kbroker.jar to the contasiner
COPY target/kbroker-0.0.1-SNAPSHOT.jar kbroker.jar
#expose the app at 8080
EXPOSE 8080
#Run the app using an array command
ENTRYPOINT ["java", "-jar", "kbroker.jar"]

    