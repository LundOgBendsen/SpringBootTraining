## Product API

This api supports CRUD on products and orders.

The API uses DTOs in order to not expose the underlying persitance layer.

The API is documented by Postman in the following link: 

https://documenter.getpostman.com/view/7586248/SVYruK83?version=latest


## Up and running

#### Database
A Database with a schema for the API. To have a samle database up and running, go to the database folder in the project and start the database with: `docker-compose up`

This command starts MySql and creates a schema for the API models, and a user for access. This user is currently setup in the APIs configuration. See `src/main/resources/application.yaml`

#### API
Use Maven to start the API: `mvn spring-boot:run`

This will start the API on `localhost:8080`

The documentation in the link above to a Postman collection have examples of all requests.



## The Code
The code is organized in the following layers:

#### Model
The model consists of JPA annotated POJOs. The model is located in the `model` package. There are 3 main entities in the API: Product, Order and OrderLine.

**Product**
A Product consists of a name and a price.

**Order**
An Order is an email, a list of OrderLines, a creation date, and an Order Sum, that is recalculated on any change to the included OrderLines. 

The Order is created from a list of products, each with an amount for purchase. 

**OrderLine**
An OrderLine consists of a snapshot of a Product (name and price) along with an amount, an OrderLine sum and a reference to the Order they are included in. 

Since OrderLines are snapshots of a Product at the time of the creation of the OrderLine, later changes to the product are not reflected in the OrderLine.
  
#### Persistence
Persistence is handled by Spring Repositories. They are located in the `repositories` package.

#### Business logic
The logic of the application is isolated into the business logic layer, which in the code is located in the `service` package.

This layer operates directly on the model, and the controller layer interacts with the layer using models.

There are two areas of business logic. One is for managing Products, and one is for Orders.

#### API
The API is handled by Spring RestControllers. The controllers are located in the `api` package.

There are two RestControllers. One for controlling Products, and one for Orders. The controllers are the point of entry to the business logic, and data is passed using DTOs. The systems model is never revealed directly to the enduser. The Controllers are responsible for translating incoming requests to models for the Service layer, and for translating models to DTOs for the response. 


## Considerations

#### Scaling
The API does not carry state between any two request and therefore supports horisontal scaling behind a loadbalancer. 

#### Configuration
Currently the API have a baked-in configuration in the form of the `application.yaml` file. Preferably this configuration should be externalized and injected to the application by the runtime environment at start up. 

#### Deployment
The API currently depends on Maven to produce a self-contained artifact, a runnable jar file. There are many ways this jar file could be deployed in a runtime environment. Ideally it should be dockerized which would make it compliant with Kubernetes and other Docker runtimes. 

An alternative (for AWS cloud deployment) would be to use Elastic Beanstalk along with Code Pipline.

#### Authentication
The API is currently unauthenticated. 

Since this is pure API, the recommendation is to use a Bearer token, where the http header "Authorization" carries a token for authentication and authoriztion.
This would of course only be acceptable if the channel is encrypted with SSL.

A suggestion for managing authentication would be to use Spring Security. Spring Security is battle proved, it is highly configurable and supports many different ways of authentication incl home-baked solutions and OpenID standards. Furthermore Spring Security provides very fine grained authorization and have many different ways of expressing relations between a Principal and a Resource.

#### Logging
The API uses slf4j to log events to the Console. The API should be deployed in an environment that forward those loggings to a centralized logging system like the ELK stack.

Furthermore, the API logging should be enhanced with the use of MDC to support "distributed tracing", where a token is generated at the beginning of an event, and then stamped into every log-lines of code invoked because of that event. This would make it possible to see how an event propagates out through the system, and possibly in to other services.
   
#### Testing
Unit tests could be a lot more elaborate. A lot of corner cases are not covered.

The Controller layer has not been subjected to Integration tests. This would be possible using SpringBootTest.   