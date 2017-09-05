# SpringBoot-Weather-Rest
Weather_Rest is a Java application rest endpoints developed in Spring Boot and include REST operations. It also make use of Swagger UI for documentation and representation.

Steps to run.
1. Import the files.
2. create database weather1_db in local mysql or at RDS follow application-prod properties file.
3. Install tomcat server
4. run as java application.
5. Open the following link in browser to access the application 
    http://localhost:8080/api/swagger-ui.html
6. Use postman to evaluate REST endpoints.
7. Data to be posted should be of following format.


{    
        "city": "chicago",
        "description": "Sunny",
        "humidity": "35",
        "pressure": "1100",
        "temperature": "35",
        "timestamp": "2017-05-14T09:48:04.000Z",
        "wind": {
            "speed": "100",
            "degree": "10"
        }
    }
