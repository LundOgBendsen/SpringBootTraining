# SpringBoot-ex08-Logging

Demonstrate logging. How to control log levels at startup and runtime via a REST API.



## How to run
1. mvn clean install (add a run config under Run configurations/maven)
2. Run [DemoApplication.java](src/main/java/dk/lundogbendsen/boot/ex08/DemoApplication.java)
3. Start a browser and go to [http://localhost:8080/](http://localhost:8080/)
4. Check the console window. Note the printouts A * Message
5. Click the red stop button in Console window to stop the server
6. Edit the Run configuration for the Java main method. 
Type this in the VM Options field:
-Dlogging.level.dk.lundogbendsen.boot.ex08.resources=TRACE
7. Run the Run Configuration
8. Start a browser and go to [http://localhost:8080/](http://localhost:8080/). 
Or press F5 in the existing browser.
9. Check the console - hopefully there's a TRACE and DEBUG message as well 
10. Click the red stop button in Console window to stop the server                             
11. Also try to change the log levet in application.properties. Try INFO and WARN.
12. Make a GET request to: http://localhost:8080/actuator/loggers/dk.lundogbendsen.boot.ex08.resources.LoggingController. 
You will se the log levels of the logger LoggingController. 
13. POST the following JSON : {"configuredLevel": "TRACE"} to http://localhost:8080/actuator/loggers/dk.lundogbendsen.boot.ex08.resources.LoggingController
14. Make a GET request to: http://localhost:8080/actuator/loggers/dk.lundogbendsen.boot.ex08.resources.LoggingController
and note that the level has changed. Try other levels. NB! In order for the REST API to be exposed security has been
turned off. See application.properties.  
      
## Note
1. See the LoggingController class for how to do the logging from Java.
2. See this useful article: https://www.baeldung.com/spring-boot-logging
