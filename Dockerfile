FROM openjdk:17
EXPOSE: 8070
ADD target/MGL-870-Book-API.jar MGL-870-Book-API.jar
ENTRYPOINT ["java", "-jar", "/MGL-870-Book-API.jar"]