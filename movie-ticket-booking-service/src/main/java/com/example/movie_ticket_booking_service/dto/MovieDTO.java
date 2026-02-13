package com.example.movie_ticket_booking_service.dto;

import com.example.movie_ticket_booking_service.enums.Genre;
import com.example.movie_ticket_booking_service.enums.Language;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MovieDTO {
    private Long movieId;
    private String movieName;
    private LocalDateTime releaseDate;
    private Integer duration;
    private Double rating;
    private Genre genre;
    private Language language;
}
