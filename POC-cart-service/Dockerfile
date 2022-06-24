#Use to run docker, docker compose file
#Openjdk is available in dockerhub
FROM openjdk:11
#Port of this microservice
EXPOSE 2368
#Adding the jar of your app
ADD target/cart-service.jar cart
#command to run the jar
ENTRYPOINT ["java","-jar","/cart"]