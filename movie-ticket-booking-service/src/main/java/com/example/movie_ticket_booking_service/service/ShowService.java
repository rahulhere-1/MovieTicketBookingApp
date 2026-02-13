package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.dto.ShowDTO;

public interface ShowService {
    ShowDTO getShowDetails(Long id);

    ShowDTO getShowDetailsByMovieId(Long movieId);

    void createShowTime(ShowDTO showDTO);

    void deleteByShowId(Long showId);
}
