package com.example.movie_ticket_booking_service.controller;

import com.example.movie_ticket_booking_service.dto.ErrorResponse;
import com.example.movie_ticket_booking_service.exception.MovieNotFoundException;
import com.example.movie_ticket_booking_service.exception.ShowNotFoundException;
import com.example.movie_ticket_booking_service.exception.TheaterNotFoundException;
import com.example.movie_ticket_booking_service.exception.UnableToCreateShowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieException(MovieNotFoundException exception){

        ErrorResponse error = new ErrorResponse();
        error.setException(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getLocalizedMessage());
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(value = ShowNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleShowException(ShowNotFoundException exception){

        ErrorResponse error = new ErrorResponse();
        error.setException(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getLocalizedMessage());
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(value = UnableToCreateShowException.class)
    public ResponseEntity<ErrorResponse> handleShowException(UnableToCreateShowException exception){

        ErrorResponse error = new ErrorResponse();
        error.setException(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage(exception.getLocalizedMessage());
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(value = TheaterNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTheaterException(TheaterNotFoundException exception){

        ErrorResponse error = new ErrorResponse();
        error.setException(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(exception.getLocalizedMessage());
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error,error.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception anyException){

        ErrorResponse error = new ErrorResponse();
        error.setException(anyException.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage("Something went wrong");
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
