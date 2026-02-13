package com.example.movie_ticket_booking_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> seatIds; // assuming seat IDs to be booked
}
