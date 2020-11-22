# Spring Boot Training
Repo for Spring and Spring Boot projects for training and courses

## Vagrant Guide
cd SpringBootTraining/vagrant
vagrant plugin install vagrant-docker-compose
vagrant up
vagrant ssh

### Run RabbitMQ
docker-compose -f /springboottraining/springboot-ex20-rabbitmq/docker-compose.yml up
### Run Redis
docker-compose -f /springboottraining/springboot-ex18-scheduler/docker-compose.yml up
### Run MySQL
docker-compose -f /springboottraining/springboot-ex19-persistence/docker-compose.yml up
### Run Mongo
docker-compose -f /springboottraining/springboot-ex10-mongo/docker-compose.yml up
### Run Kibana
docker-compose -f /springboottraining/SpringBoot-ex08-Logging/docker-compose.yml up


When script is complete(ca 3-5 minutter), use your browser to hit localhost:15672 and login as guest/guest



## Project overview

| No     | Project                                                            | Description                         |
| ------:| ------------------------------------------------------------------ | ----------------------------------- |
| 1      | [Maven-ex01-iText](Maven-ex01-iText)                               | A Maven demo using iText            |
| 2      | [Maven-ex02-ApachePOI](Maven-ex02-ApachePOI)                       | A Maven demo using Apache POI       |
| 3      | [SpringBoot-ex01-HelloSpringBoot](SpringBoot-ex01-HelloSpringBoot) | A simple Spring Boot rest service   |
| 4      | [SpringBoot-ex02-JpaTx](SpringBoot-ex02-JpaTx)                     | Jpa, transactions, h2-db, and test  |
| 5      | [SpringBoot-ex03-Docker](SpringBoot-ex03-Docker)                   | A simple boot app running in docker |
| 6      | [SpringBoot-ex04-DI](SpringBoot-ex04-DI)                           | Dependency injection explained      |
| 7      | [SpringBoot-ex05-Lombok](SpringBoot-ex05-Lombok)                   | Lombok explained                    |
| 8      | [SpringBoot-ex06-Servlets](SpringBoot-ex06-Servlets)               | Demonstrating servlets and filters  |
| 9      | [SpringBoot-ex07-Currency](SpringBoot-ex07-Currency)               | Demonstrating Scheduling            |
| 10     | [SpringBoot-ex10-mongo](springboot-ex10-mongo)                     | Demonstrating Repository with mongo |
| 11     | [springboot-examn](springboot-examn)                               | Assignment for students ending spring course |




