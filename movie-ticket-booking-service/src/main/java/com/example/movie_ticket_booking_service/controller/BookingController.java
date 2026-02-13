package com.example.movie_ticket_booking_service.controller;

import com.example.movie_ticket_booking_service.dto.BookingRequestDTO;
import com.example.movie_ticket_booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookMovieTicket(@RequestBody BookingRequestDTO bookingRequestDTO) {
        boolean isBooked = bookingService.bookTicket(bookingRequestDTO.getUserId(),
                bookingRequestDTO.getShowId(),
                bookingRequestDTO.getSeatIds());
        if (isBooked) {
            return new ResponseEntity<>("Booking successful", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Booking failed. Seats might be unavailable.", HttpStatus.CONFLICT);
        }
    }
}
