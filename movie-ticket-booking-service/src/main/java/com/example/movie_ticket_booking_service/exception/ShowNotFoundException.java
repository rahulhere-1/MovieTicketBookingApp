package com.example.movie_ticket_booking_service.exception;

public class ShowNotFoundException extends RuntimeException {

    public ShowNotFoundException(String msg){
        super(msg);
    }
}
