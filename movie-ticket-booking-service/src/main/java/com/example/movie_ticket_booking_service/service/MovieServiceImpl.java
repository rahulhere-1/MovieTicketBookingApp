package com.example.movie_ticket_booking_service.service;


import com.example.movie_ticket_booking_service.enums.Status;
import com.example.movie_ticket_booking_service.exception.MovieNotFoundException;
import com.example.movie_ticket_booking_service.dto.MovieDTO;
import com.example.movie_ticket_booking_service.model.Movie;
import com.example.movie_ticket_booking_service.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO getMovieDetails(Long movieId){
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not Found"));
        MovieDTO dto = new MovieDTO();
        dto.setMovieId(movie.getId());
        dto.setMovieName(movie.getName());
        dto.setDuration(movie.getDuration());
        return dto;
    }

    @Override
    public List<MovieDTO> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> moviesList = new ArrayList<>();
        for(Movie mov : movies){
            if(mov.getStatus()== Status.ACTIVE) {
                MovieDTO dto = new MovieDTO();
                dto.setMovieId(mov.getId());
                dto.setMovieName(mov.getName());
                dto.setDuration(mov.getDuration());
                dto.setGenre(mov.getGenre());
                moviesList.add(dto);
            }
        }
        return moviesList;
    }

    @Override
    public void saveMovie(MovieDTO dto){
        Movie movie = new Movie();
        movie.setName(dto.getMovieName());
        movie.setDuration(dto.getDuration());
        movie.setGenre(dto.getGenre());
        movieRepository.save(movie);
    }
}
