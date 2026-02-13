package com.example.movie_ticket_booking_service.service;


import java.util.List;

public interface BookingService {
    boolean bookTicket(Long userId, Long showId, List<Long> seatIds);
}
