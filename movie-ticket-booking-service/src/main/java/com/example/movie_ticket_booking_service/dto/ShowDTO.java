package com.example.movie_ticket_booking_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShowDTO {
    private Long showId;
    private LocalDateTime showTime;
    private Long movieId;
    private MovieDTO movieDTO;
    private List<ShowDTO> showDtoList;
}
