FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
ADD ./target/mvsc-products-0.0.1-SNAPSHOT.jar mvsc-products.jar

ENTRYPOINT ["java","-jar","mvsc-products.jar"]