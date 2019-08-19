# SpringBoot-ex06-Servlets

Showing how to use servlets and web filters in a Spring Boot application.
Servlets and Filters origin from the JavaWeb specification; part of Java EE.


## How to run
1. mvn clean install (add a run config under Run configurations/maven)
2. Run [DemoApplication.java](src/main/java/dk/lundogbendsen/springboot/ex06/DemoApplication.java)
3. Start a browser and go to [http://localhost:8080/servlet](http://localhost:8080/servlet)
4. Start a browser and go to [http://localhost:8080/servlet?name=Roy+Fielding](http://localhost:8080/servlet?name=Roy+Fielding)
5. Check the console window. Note the printout from MyFilter
6. Click the red stop button in Console window to stop the server                             
      
## Note
1. filters.MyFilter class demonstrates a ServletFilter
2. servlets.HelloServlet demonstrates a Servlet                        
3. DemoApplication class is responsible for registering the servlet and the filter 
