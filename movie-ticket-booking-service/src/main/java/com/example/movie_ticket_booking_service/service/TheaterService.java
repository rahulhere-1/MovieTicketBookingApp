package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.dto.ScreenDTO;
import com.example.movie_ticket_booking_service.dto.TheaterDTO;

import java.util.List;

public interface TheaterService {
    void addTheater(TheaterDTO dto);

    void addScreensToTheater(ScreenDTO screenDTO);

    List<ScreenDTO> getScreensForTheater(Long theaterId);
}
