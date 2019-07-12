# SpringBoot-ex05-Lombok

Showing multiple ways of using Lombok; a source code generation tool for Java. 

## Prerequisites
1. Install lombok plugin (file>settings...>Plugins>Marketplace, search for 'Lombok')
2. Activate annotation processing (file>settings>Build,execution...>compiler>annotation processors)

## How to run
1. mvn clean install (add a run config under Run configurations/maven)
2. Run [DemoApplication.java](src/main/java/dk/lundogbendsen/springboot/ex05/DemoApplication.java)
3. Start a browser and go to [http://localhost:8080/customers/1](http://localhost:8080/customers/1)
4. Start a browser and go to [http://localhost:8080/customers](http://localhost:8080/customers)
5. Start a browser and go to [http://localhost:8080/cars/1](http://localhost:8080/cars/1)
6. Click the red stop button in Console window to stop the server                             
      
## Note
1. model.Bean class demonstrates the @Data annotation
2. model.Car demonstrates generating only get'ers                        

## See
* [Lombok documentation](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)
* [Lombok configuration in IntelliJ](https://www.baeldung.com/lombok-ide)

