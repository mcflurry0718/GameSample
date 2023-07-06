Game Service Provider 
    
    This project is an application that manages games within a game service provider environment. It is developed using Java, Spring, and Maven. 
    The application provides a GameService interface that handles CRUD operations related to games. 
    Each game object has a unique name, creation date, and active status. 
    The project also includes an in-memory cache structure that takes into account concurrency and potential performance issues. 
    The application exposes REST endpoints to utilize the implemented GameService within the Spring application.

Prerequisites
    
    To run this application, you need to have Java 11 or higher installed on your machine.

Usage
    
    The application provides the following REST endpoints:

    GET /games: Returns a list of all games in the system.
    GET /games/{id}: Returns a specific game by ID.
    POST /games: Creates a new game.
    PUT /games/{id}: Updates an existing game by ID.
    DELETE /games/{id}: Deletes a game by ID.

Dependencies

    The project uses the following dependencies:
    
    Spring Boot
    Spring Web
    Spring Data JPA
    H2 Database Engine
    JUnit 5
