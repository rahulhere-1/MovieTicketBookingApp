package com.example.movie_ticket_booking_service.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message){
        super(message);
    }
}
