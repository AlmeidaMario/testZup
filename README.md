
# ZUP Test  :sunglasses: :computer:

This project is a WebAPI developed in SpringBoot with Java 11 based in RestFull pattern. In this project was use [Junit5](https://junit.org/junit5/) for test, [PMD](https://pmd.github.io/) for CodeReview, [SwaggerUI](https://swagger.io/tools/swagger-ui/) for fast prototype and [PostMan](https://www.getpostman.com/) to make requests.

## Installation

### Running Database

To run database for this project is required to have docker installed after that run command bellow.
````
docker run --name postgreSQL -p 5433:5432 --restart=always  -e POSTGRES_PASSWORD=123456 -d postgres
````

### Running API
To run the API is required to have **Maven** and **Java 11** installed.
````
mvn clean spring-boot run
````
When the process is done, access the API: [http://localhost:9999/api/swagger-ui.html#/](http://localhost:9999/api/swagger-ui.html#/) 

If is necessary to use postman to make API Request, there is a collection in  root directory with name: TestZup_MárioAlmeida.postman_collection.json

### Running API Test
To run the API is required to have **Maven** and **Java 11** installed.
````
mvn clean test
````

 
