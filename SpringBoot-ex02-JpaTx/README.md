# SpringBoot-ex02-JpaTx

Shows the following
* Persistence with JPA, H2-database, and @Repository
* A service tier using @Service
* Use of @Transactional to control transactions 
* Automatic rollback if Exceptions are thrown
* Automates tests using @DataJpaTest
* Use of application.properties


## How to run
1. mvn clean install (add a run config under Run configurations/maven)
2. Run [BootApplication.java](src/main/java/dk/lundogbendsen/boot/BootApplication.java)
3. Start a browser try these urls
* [http://localhost:8080/init](http://localhost:8080/init) to create 10 random accounts
* [http://localhost:8080/accounts](http://localhost:8080/accounts) to GET all accounts
* [http://localhost:8080/accounts/1](http://localhost:8080/accounts/1) to GET account with id=1
* [http://localhost:8080/accounts/transfer?from=1&to=2&amount=300](http://localhost:8080/accounts/transfer?from=1&to=2&amount=300) Transfer money - no errors
* [http://localhost:8080/accounts/transferWithError?from=1&to=2&amount=300&fail=true](http://localhost:8080/accounts/transferWithError?from=1&to=2&amount=300&fail=true) Transfer money, throw exception, observe automatic rollback


4. Click the red stop button in Console window to stop the server                             
                              
Created from [https://start.spring.io/](https://start.spring.io/).







