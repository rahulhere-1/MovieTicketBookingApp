package com.example.movie_ticket_booking_service.exception;

public class TheaterNotFoundException extends RuntimeException {
    public TheaterNotFoundException(String theaterNotFound) {
        super(theaterNotFound);
    }
}
