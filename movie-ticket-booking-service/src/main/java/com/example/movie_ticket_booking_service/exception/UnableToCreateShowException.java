package com.example.movie_ticket_booking_service.exception;

public class UnableToCreateShowException extends RuntimeException {

    public UnableToCreateShowException(String message){
        super(message);
    }
}
