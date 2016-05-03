# GuitarPlayersDataApi
Rest api for delivering and managing information about guitars, guitar players and guitar rig

# Main technologies: 
* Java 8, Spring MVC, Spring Boot, MySql,
* Spring Data JPA, REST, AngularJS

# Runnin the app in terminal:

## 1.(without inserting test data into db)
* mvn clean install
* mvn spring-boot:run 

## 2.(with inserting test data into db)
* mvn clean install
* mvn spring-boot:run -Drun.arguments="init_db_data" 

