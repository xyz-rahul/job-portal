# Job Portal
#### Using Spring Boot + React


## Spring Boot


Spring Boot Web Java backend application that exposes a REST API.
Spring-backend stores its data in a MySql database.


### Technologies Used

- Spring Boot
- Spring Data JPA (Java Persistence API)
- MySQL
- JSR 380 (Java Specification Request 380 - Bean Validation)
- Swagger (for API documentation)
- Lombok

## Steps to Setup Server

**1. Clone the application**

```bash
git clone https://github.com/xyz-rahul/job-portal.git
```

**2. Create Mysql database**
```bash
create database job_portal
```
**3. Set Mysql `username` and `password` in `application.properties`**
```bash
spring.datasource.username=[your_username]
spring.datasource.password=[your_password]
```
**4. set `port` for app**

```bash
server.port = [your_port_number]
```
or leave it default to `8080`

**5. Run the app using maven**

```bash
./mvnw spring-boot:run
```
spring app will start running at `http://localhost:[your_port_number]` eg: `http://localhost:8080`

## API Documentation

The API documentation is generated using Swagger. To access the Swagger documentation, follow these steps:

1. Make sure you have started the Blog App REST API server.

2. Open your web browser and visit the following URL:
   `http://localhost:8080/swagger-ui/index.html`

![Swagger docs example](assets/swagger-job-controller.jpg?raw=true "Swagger docs example")



# React

React fetches data from APIs endpoint exposes by server.

## Steps to Setup React

**1. move in to client folder**

```bash
cd client
```


**1. Intall npm**

```bash
npm install
```

**2. Start Application**
```bash
npm start
```

## Job page
![Job page example](assets/jobsPage.gif?raw=true  "job page example")




# MySQL Schema
## Job page
![Job page example](assets/db_schema.png?raw=true  "job page example")