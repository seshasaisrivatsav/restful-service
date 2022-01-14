## Restful service

- written in spring boot

### Running the app locally
```shell script
    ~ source env.sh
    ~ mvn clean install
    ~ mvn spring-boot:run
```
- Once the app runs locally
## Project Structure Be like
        src
        ├── main
        |   ├── java
        |   |   ├── com
        |   |   |   ├── sesha
        |   |   |   |   ├── restfulService
        |   |   |   |   |   ├── RestfulServiceApplication.java  ## Entry point (Must be at top level)
        |   |   |   |   |   ├── controller
        |   |   |   |   |   |   ├── v1
        |   |   |   |   |   |   |   ├── controller.java         ## Controllers
        |   |   |   |   |   ├── config                          ## database/security/web config
        |   |   |   |   |   ├── dto                             ## DTO
        |   |   |   |   |   ├── constants                       ## constants
        |   |   |   |   |   ├── healthcheck                     ## healthcheck / LDAP healthcheck
        |   |   |   |   |   ├── service                         ## Internal service related
        |   |   |   |   |   ├── utils                           ## Helpers/ utilities
        |   |   |   |   |   ├── ldap                            ## LDAP / feign request interceptor, can set authorization
        |   |-- resources
        |   |   |-- static
        |   |   |-- templates
        |   |   |-- application.properties
        |-- test
        |   |-- java
        |   |   |-- com
        |   |   |   |-- sesha
        |   |   |   |   |-- restfulservive
        |   |   |   |   |   |-- RestfulApplicationTests.java
        └── pom.xml