package com.example.movie_ticket_booking_service.service;


import com.example.movie_ticket_booking_service.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO getMovieDetails(Long movieId);

    List<MovieDTO> getAllMovies();

    void saveMovie(MovieDTO dto);
}
