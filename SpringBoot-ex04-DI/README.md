# SpringBoot-ex04-DI

Showing multiple ways of doing injection

Greeter.java uses different ways of injection: field, constructor, setter.

Notice the @Bean annotated method in DemoApplication. It's responsible for creating the bean instance. 

## How to run
1. mvn clean install (add a run config under Run configurations/maven)
2. Run [DemoApplication.java](src/main/java/dk/lundogbendsen/springboot/ex04/DemoApplication.java)
3. Start a browser and go to [http://localhost:8080](http://localhost:8080)
4. Click the red stop button in Console window to stop the server                             
                              
                              
Created from [https://start.spring.io/](https://start.spring.io/).







