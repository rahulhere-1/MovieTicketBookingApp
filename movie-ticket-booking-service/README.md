# Movie Ticket Booking Service

A robust Spring Boot backend service for a movie ticket booking application. This service handles user authentication, movie management, theater/screen management, show scheduling, and ticket booking.

## 🚀 Features

*   **User Management**: Secure signup and login with JWT authentication.
*   **Movie Management**: Add movies and view movie details.
*   **Theater & Screen Management**: Manage theaters and their screens.
*   **Show Management**: Schedule shows for movies in specific theaters.
*   **Booking System**: Book tickets for shows with seat selection.
*   **Security**: Role-based access control (implied) and secure password handling.

## 🛠️ Tech Stack

*   **Language**: Java 17+
*   **Framework**: Spring Boot 3.x
*   **Build Tool**: Maven
*   **Database**: MySQL/PostgreSQL (Configured in properties)
*   **Security**: Spring Security, JWT (JSON Web Tokens)
*   **Documentation**: REST API (documented below)

## 📋 Prerequisites

Ensure you have the following installed:
*   Java Development Kit (JDK) 17 or higher
*   Maven (or use the provided `mvnw` wrapper)
*   A running database instance (configure connection in `application.properties`)

## ⚙️ Setup & Running

1.  **Clone the repository** (if you haven't already).
2.  **Navigate to the project directory**:
    ```bash
    cd movie-ticket-booking-service
    ```
3.  **Configure Database**:
    Open `src/main/resources/application.properties` and update your database credentials.
4.  **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

## 🔐 Authentication

 The API uses **JWT (JSON Web Tokens)** for authentication.
1.  **Login** using Basic Auth at `/user`.
2.  The response header `Authorization` will contain the JWT token.
3.  Include this token in the `Authorization` header for all subsequent requests to `/api/**` endpoints.

## 📡 API Documentation

### **User Controller**
*   **Sign Up**
    *   `POST /signup`
    *   **Body**: `UserDetailsDTO` ({`username`, `password`, `role`, ...})
    *   **Description**: Register a new user.
*   **Login**
    *   `POST /user`
    *   **Body**: `UserDetailsDTO` ({`username`, `password`})
    *   **Description**: Authenticate user and receive JWT token.

### **Movie Controller** (`/api/movie`)
*   **Get Movie Details**
    *   `GET /api/movie/details?id={movieId}`
    *   **Description**: Fetch details of a specific movie.
*   **Get All Movies**
    *   `GET /api/movie/all-movies`
    *   **Description**: Retrieve a list of all movies.
*   **Add Movie**
    *   `POST /api/movie/save`
    *   **Body**: `MovieDTO`
    *   **Description**: Add a new movie to the database.
*   **Health Check**
    *   `GET /api/movie/health-check`
    *   **Description**: Check if the server is running.

### **Booking Controller** (`/api/booking`)
*   **Book Ticket**
    *   `POST /api/booking/book`
    *   **Body**: `BookingRequestDTO` ({`userId`, `showId`, `seatIds`})
    *   **Description**: Book tickets for a specific show. Returns success or conflict if seats are unavailable.

### **Show Controller** (`/api/show`)
*   **Get Show Details**
    *   `GET /api/show/details?showId={showId}`
    *   **Description**: Get details of a specific show.
*   **Get Shows by Movie**
    *   `GET /api/show/all-shows?movieId={movieId}`
    *   **Description**: List all shows for a specific movie.
*   **Add Show**
    *   `POST /api/show/save`
    *   **Body**: `ShowDTO`
    *   **Description**: Schedule a new show.
*   **Delete Show**
    *   `DELETE /api/show/delete?showId={showId}`
    *   **Description**: Cancel/Remove a scheduled show.

### **Theater Controller** (`/api/theater`)
*   **Get Screens**
    *   `GET /api/theater/all-screens?theaterId={theaterId}`
    *   **Description**: Get all screens in a specific theater.
*   **Add Theater**
    *   `POST /api/theater/save`
    *   **Body**: `TheaterDTO`
    *   **Description**: Register a new theater.
*   **Add Screens**
    *   `POST /api/theater/save/screens`
    *   **Body**: `ScreenDTO`
    *   **Description**: Add screens to an existing theater.

### **Screen Controller** (`/api/screen`)
*   *(No public endpoints currently exposed)*
