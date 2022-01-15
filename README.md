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
        
## Requests
- NOTE: All the POJOs / DTOs need to have getters in order for them to show up in response
- NOTE: if you're calling another service, and returning a MODEL, make sure that model has empty constructor and  `@JsonProperty` 
for the attribute

- Are made using `@RequestMapping`
    - `@GetMapping`
    - `@PostMapping`
    - `@DeleteMapping`
    
- `@RequestBody` = this annotation allows to retrieve the request's body. 
    - This can be returned as a String or deserialize it to POJO
    - Enables automatic deserialization of inbound HttpRequest body into Java Object
    
- `@ResponseBody` = Tells a controller that object returned is automatically serialized into JSON and passed back into HttpResponse object
```java
    public class ResponseTransfer {
        private String text; 
    }
    
    @PostMapping("/responseBodyTest")
    @ResponseBody
    public ResponseTransfer postResponseController(
      @RequestBody LoginForm loginForm) {
        return new ResponseTransfer("Thanks For Posting!!!");
     }
```