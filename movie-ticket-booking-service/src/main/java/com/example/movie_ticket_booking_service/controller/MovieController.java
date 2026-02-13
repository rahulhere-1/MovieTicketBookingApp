package com.example.movie_ticket_booking_service.controller;


import com.example.movie_ticket_booking_service.dto.MovieDTO;
import com.example.movie_ticket_booking_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/details")
    public ResponseEntity<MovieDTO> getMovieDetails(@RequestParam("id") Long movieId){

        MovieDTO response = movieService.getMovieDetails(movieId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-movies")
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        List<MovieDTO> response = movieService.getAllMovies();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMovie(@RequestBody MovieDTO request){
        movieService.saveMovie(request);
        return new ResponseEntity<>("added movie successfully",HttpStatus.CREATED);
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> getServerStatus(){
        return new ResponseEntity<>("server running fine... ",HttpStatus.OK);
    }
}
