package com.example.movie_ticket_booking_service.controller;

import com.example.movie_ticket_booking_service.dto.ShowDTO;
import com.example.movie_ticket_booking_service.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/details")
    public ResponseEntity<ShowDTO> getShowDetails(@RequestParam("showId") Long showId){
        ShowDTO response = showService.getShowDetails(showId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-shows")
    public ResponseEntity<ShowDTO> getShowDetailsByMovie(@RequestParam("movieId") Long movieId){
        ShowDTO response = showService.getShowDetailsByMovieId(movieId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveShow(@RequestBody ShowDTO request){
        showService.createShowTime(request);
        return new ResponseEntity<>("show created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteShowTime(@RequestParam Long showId){
        showService.deleteByShowId(showId);
        return new ResponseEntity<>("show deleted successfully",HttpStatus.OK);
    }
}
