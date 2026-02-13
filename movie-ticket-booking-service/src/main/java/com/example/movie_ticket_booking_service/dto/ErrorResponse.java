package com.example.movie_ticket_booking_service.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private String exception;
    private LocalDateTime timestamp;

}
