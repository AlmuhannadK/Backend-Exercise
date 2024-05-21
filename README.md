# Todo with Spring Boot

## Overview
This project is a Todo List API developed using Spring Boot. It provides endpoints for managing todo lists and their items and includes user authentication and authorization to ensure that users can only access their data

## Features
- User registration and authentication
- Basic operations on Todo lists and Todo items and Users
- Secure access with JWT (JSON Web Tokens)
- Global exception handling.

## Technologies
- **Spring Boot 3 (version 3.2.5)**
- **Spring Security with JWT**: for authentication and authorization
- **H2 Database**: In-memory database for testing
- **Maven**: dependency management and project build
- **Lombok**: To reduce boilerplate code

## Entity Diagram
- Simple visual representation of the relationships between entities in the project

![Todo ER Diagram](https://github.com/AlmuhannadK/Backend-Exercise/assets/47474960/c01e031a-bb29-40b4-a44e-8b6d2d633507)

## Getting Started

### Prerequisites

- JDK 17+
- Maven

### Installing and running

1. Clone the repository "git clone https://github.com/AlmuhannadK/Backend-Exercise.git"
2. Navigate to project directory in your machine
3. open with an IDE and run application. (for CLI use "mvn install" then "mvn spring-boot:run" to run)
4. To access H2 database after running, navigate to this URL: (localhost:8080/h2-console). **the default username and password is admin**.


--- 

# API Endpoints

## Authentication Controller  (/api/v1/auth)


### Register User
- **POST /registration**
    - Description: Registers a new user
    - Request body:
      ```json
      {
        "username": "newUser",
        "password": "password123"
      }
      ```
    - Response: `200 OK` with user authentication details.

### Login User
- **POST /login**
    - Description: Authenticates a user and returns a JWT for accessing protected endpoints
    - Request body:
      ```json
      {
        "username": "existingUser",
        "password": "password123"
      }
      ```
    - Response: `200 OK` with JWT token.

## User Controller (api/v1/users)


### Get All Users (Admin only)
- **GET /admin**
    - Required: `ADMIN` authority
    - Description: Retrieves a list of all users
    - Response: `200 OK` with a list of users for admin, otherwise `403 Forbidden`

### Create User (Admin only)
- **POST /admin**
    - Required: `ADMIN` authority
    - Description: Creates a new user
    - Request body:
      ```json
      {
        "username": "newAdmin",
        "password": "adminPassword",
        "role": "ADMIN or USER"
      }
      ```
    - Response: `200 OK` with created user details for admin, otherwise `403 Forbidden`

### Get User by ID (Admin only)
- **GET /admin/{userId}**
    - Required: `ADMIN` authority
    - Description: Retrieves user details by user ID
    - Path variable: `userId` (long, minimum value 1)
    - Response: `200 OK` with user details or `404 Not Found` if not found for admin, otherwise `403 Forbidden`

### Search for User by Username
- **GET /search**
  - Required: user authenticated
  - Description: Retrieves user details by username
  - Path variable: `userId` (long, minimum value 1)
  - Response: `200 OK` with user details or `404 Not Found` if not found for admin, otherwise `403 Forbidden`


## Todo Lists Controller (/api/v1/todo-list)


### Get All Todo Lists
- **GET**
  - Required: user authenticated
  - Description: Retrieves all todo lists owned by the authenticated user
  - Response: `200 OK` with a list of todo lists

### Get Todo List by ID (Admin only)
- **GET /admin/{todoListId}**
  - Required: `ADMIN` authority
  - Description: Retrieves a specific todo list by ID
  - Path variable: `todoListId` (long, minimum value 1)
  - Response: `200 OK` with todo list details or `404 Not Found` if not found for admin, otherwise `403 Forbidden`

### Get Todo List by Title
- **GET /search**
  - Required: user authenticated
  - Description: Searches for a todo list by title owned by the authenticated user
  - Request param: `listTitle` (string)
  - Response: `200 OK` with todo list details or `404 Not Found` if not found for admin, otherwise `403 Forbidden`

### Create Todo List
- **POST**
  - Required: user authenticated
  - Description: Creates a new todo list for authenticated user
  - Request body:
    ```json
    {
      "title": "New Todo List"
    }
    ```
  - Response: `200 OK` with created todo list details


## Todo Items Controller (/api/v1/todo-items)

### Get All Todo Items (Admin only)
- **GET /admin**
  - Required: `ADMIN` authority
  - Description: Retrieves all todo items across all lists
  - Response: `200 OK` with a list of todo items for admin, otherwise `403 Forbidden`

  
### Create Todo Item
- **POST /{todoListId}/items**
    - Required: user authenticated
    - Description: Adds a new todo item to a specified todo list that belongs to user. If user is a new user, then he must create a new list with todo-list controller via createTodoList endpoint 
    - Path variable: `todoListId` (long)
    - Request body:
      ```json
      {
        "description": "Learn spring boot",
        "status": "PENDING",
        "dueDate": "2024-1-1"
      }
      ```
    - Response: `200 OK` with created todo item details for authenticated users, otherwise `403 Forbidden`

### Update Todo Item Status
- **POST /{todoItemId}/status**
  - Required: user authenticated
  - Description: Updates the status of a specific todo item in a user's todo list
  - Path variable: `todoItemId` (long)
  - Request body:
    ```json
    {
      "status": "COMPLETED"
    }
    ```
  - Response: `200 OK` with updated todo item details or `404 Not Found` if the item does not exist

---

## Future Enhancements

some feature that I would like to add in the near future.

### DTOs 

- Use Data Transfer Objects (DTOs) for all req & res in the controller and service layers


### Entity-to-DTO Mapping with MapStruct

- Use MapStruct to simplify conversion between entity models and DTOs

### Logging Capabilities

- Implement logging in the application to aid in troubleshooting and monitoring the application's behavior
