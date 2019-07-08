# SpringBootTraining\SpringBoot-ex03-Docker

Showing how to make a docker image with a spring boot application

Make sure you have docker installed. 

## How to run
1. mvn install dockerfile:build(add a run config under Run configurations/maven). 
2. Go to a prompt
3. Run container: docker run -p 8080:8080 -t lb/springboot-ex03-docker  
4. Start a browser. Go to localhost:8080. Hello Docker world should be desplayed.
5. Stop the container
    1. docker ps (find the container id)
    2. docker stop <container id>
                                    







