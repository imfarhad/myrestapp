FROM openjdk:12
ADD target/myrestapp.jar myrestapp.jar
ENTRYPOINT ["java", "-jar", "myrestapp.jar"]
EXPOSE 8080
