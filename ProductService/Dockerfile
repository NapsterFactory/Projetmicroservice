FROM openjdk:11
EXPOSE 8081
ADD target/ProductService-1.0-SNAPSHOT.jar productmicroservice.jar
ENTRYPOINT [ "java","-jar", "productmicroservice.jar"]