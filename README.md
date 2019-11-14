# Zemoga test

Profile API query and visualization

## Getting Started

Modify the file `application.yml` and add the proper keys for twitter

```
twitter4j:
     oauth:
       access-token: --your key ---
       access-token-secret: --your key ---
       consumer-key: --your key ---
       consumer-secret: --your key ---
```

Also the DB config params:

```
spring:
     datasource:
       url: -- database UR
       username: -- database user
       password: -- database pswd
       driverClassName: com.mysql.cj.jdbc.Driver
```

For security reasons they are not on the source code

Swagger will guide the input parameters for the services

To run the project open the console and use:

* `git clone https://github.com/jramirezl/zemoga-web.git

* ```mvn clean install```

and then 
* ```mvn spring-boot:run```

After that you can open the next links:

* [Index Swagger](http://localhost:8080/swagger-ui.htm)
* [Index Profiles Page](http://localhost:8080/profile-view/home)

### Prerequisites

* java 8 
* maven


### Considerations
- Connected to mysql existing database on the repository layer
- Used the columns exists on the `portfolio` table
- The project is going to run on the defaults configuration: `localhost:8080`

### Features

Completed parts:

- PART I
    -Able to read tweets
    -Show them and profile on the GUI
- PART II
    - QUery user by title field on the database, on the app it will be `name



### Future Improvements
- Add validations for invalid data
- Improve page styling
- Wire the REST API to frond end
- Support the `application/json+userdb` at the moment is just supporting to `application/json`

## Deployment

run ```mvn install``` and  to run t 
and then 
```mvn spring-boot:run```

### Running tests

to run test open the terminal on the project folder and run 
``mvn test``

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JQuery](https://jquery.com/) - JS on the page
* [Bootstrap](https://getbootstrap.com/) - CSS for styling the website
* [popper](https://popper.js.org/) - Tooltip utils
* [projectlombok](https://projectlombok.org/) - Usefull annotations for Objects
* [webjars](https://www.webjars.org/) - JS libraries on maven
* [springfox-swagger-ui](https://github.com/Netflix/Hystrix) - API documentation
* [jsdk-11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) - jsdk
* [twitter4j](http://twitter4j.org/en/) - Read Tweets
* [modelmapper](http://modelmapper.org/) - one object model maps to another
* [twitter4j-spring-boot-starter-parent](https://github.com/sivaprasadreddy/twitter4j-spring-boot-starter) -twitter4j-spring-boot-starter-parent adapted and modified


##terms
- The MVC application should be developed on Spring MVC 5.0+ - `done`
- The data access should be developed using Hibernate. - `done`
- The application should work on Tomcat 8.5+ or JBoss 7.1.4 - `done`
- The application should be compiled on JDK11+ - `done`
- Include some sort of unit tests (i.e E2E, integration, etc) - `Unit testing only`

## Authors

* **Juan Pablo Ramirez L** - *Initial work* 

