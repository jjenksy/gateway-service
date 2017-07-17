# Netflix OSS Zuul Gateway Service
The gateway service provides a single endpoint to navigate to all the services that are enabled in the Eureka server.
For example if you have the Gateway service running on port 9000 and a service registered with the Eureka server called service
then if you navigeted to http://localhost:9000/service then you would get root endpoint of that service served up for
consumption


## Getting Started

This project is the service that uses the Netflix OSS Zuul project and Dynamic routing to route to the
various microservices endpoints
### Things that make this project bootiful

What things you need to install the software and how to install them

```
@EnableDiscoveryClient
```

This annotation is where most of the magic happens turns the service app into a client of the Discovery Server
```
@EnableZuulProxy//dynamic routing with zuul
```
### Installing

Running the project with maven using arguments to set the properties variables

```
mvn spring-boot:run 
```
The application.yml magic
```
spring:
  application:
    name: gateway-service
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
```
Name of the service and the location of the Eureka server

### Filters in Netflix OSS Zuul
``pre`` Before the request
``route`` Direct the request
``post`` After the request is routed
``error`` handle request to error

To define a Zuul filter create a class the extends ``ZuulFilter``
and implement its methods.
```
    //the type of filter pre, route, post, error
    @Override
    public String filterType() {
        return null;
    }
    //order of execution with respect to other filters to execute
    @Override
    public int filterOrder() {
        return 0;
    }
    //whether or not to run the filter
    @Override
    public boolean shouldFilter() {
        return false;
    }
    //filter logic
    @Override
    public Object run() {
        return null;
    }
```
## Actuator
Access the actuator through postman or curl at:
```
localhost:<port>/mappings
```
To view the metrics navigate to:

```
localhost:<port>/metrics
```
To view the info.
```
localhost:<port>/info
```
## Running the tests
Tests are ran by executing the command:
```
mvn test
```
A jacoco test coverage report by running the command:
```
mvn jacocoTestReport
```

To view the report navigate to build/report/jacoco/test/html/index.html

## Testing the API endpoints
The endpoints are easily viewed and tested using Swagger-UI to run the UI use the command
```
mvn spring-boot:run
```
and navigate to http://localhost:8080/swagger-ui.html each of the endpoints are exposed through the UI and data can be 
passed to the controller here.


## Authors

* **John Jenkins** - (https://github.com/jjenksy)