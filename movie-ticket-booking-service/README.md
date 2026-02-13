# Movie Ticket Booking 

This project is built with Spring Boot and delivers everything you need to search for movies, reserve seats, and manage screenings with total security and ease. Fortified with JWT authentication, your data and bookings are always protected.
## Features

- **User Registration \& Authentication**
    - Register and login securely using JWT tokens.
- **Browse Movies \& Shows**
    - View currently running movies and upcoming releases.
    - Check showtimes and available seats for each movie.
- **Book Tickets**
    - Select desired movie, time, and number of seats.
- **Manage Bookings**
    - View, update, or cancel bookings.
- **Admin Panel**
    - Add, edit, or remove movies and showtimes.
- **Fully Secured**
    - All core endpoints require JWT authentication to prevent unauthorized access.
- **RESTful APIs**
    - Designed to work seamlessly with web or mobile frontends.


## Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **Security:** Spring Security with JWT
- **ORM:** Spring Data JPA
- **Build Tool:** Maven


## Getting Started

### Prerequisites

- Java 17+
- Maven


### Installation

1. **Clone the repo**

```sh
git clone https://github.com/your-username/MovieTicketBooking.git
cd MovieTicketBooking
```

2. **Build the project**

```sh
mvn clean install
```

3. **Run the application**

```sh
mvn spring-boot:run
```


Application will start on `http://localhost:8080/`

## Usage

### Register \& Login

- Use `/api/signup` to create a new user.
- Login through `/api/user` to receive a JWT token.


### Booking Tickets

- Browse movies with `/api/movies/all-movies`
- View available showtimes `/api/show/details?showId={id}`
- Book tickets by POSTing to `/api/booking/book` (JWT required)


## Customization

- Database properties can be set in `src/main/resources/application.properties`.
- Switch databases by changing the connection URL and adding the relevant driver dependencies.


## Security

- All endpoints (except login/register) require a valid JWT in `Authorization: Bearer <token>` header.
- Roles: **USER** (basic booking), **ADMIN** (manage movies, shows).


## License

This project is licensed under the MIT License.

## Author

- Rahul

Happy Booking!

