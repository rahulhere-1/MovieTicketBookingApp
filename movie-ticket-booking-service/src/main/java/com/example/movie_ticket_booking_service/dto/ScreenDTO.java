package com.example.movie_ticket_booking_service.dto;


import com.example.movie_ticket_booking_service.model.Seat;
import lombok.Data;

import java.util.List;

@Data
public class ScreenDTO {

    private Long screenId;
    private String screenName;
    private List<Seat> seatList;
    private Integer capacity;
    private Long theaterId;

}
