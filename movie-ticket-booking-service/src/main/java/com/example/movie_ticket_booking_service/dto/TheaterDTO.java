package com.example.movie_ticket_booking_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class TheaterDTO {

    private Long theaterId;
    private String theaterName;
    private String city;
    private List<ScreenDTO> screenDTOList;
}
