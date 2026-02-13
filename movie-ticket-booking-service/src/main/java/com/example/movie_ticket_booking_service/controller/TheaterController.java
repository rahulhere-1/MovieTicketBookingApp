package com.example.movie_ticket_booking_service.controller;

import com.example.movie_ticket_booking_service.dto.ScreenDTO;
import com.example.movie_ticket_booking_service.dto.TheaterDTO;
import com.example.movie_ticket_booking_service.repo.TheaterRepository;
import com.example.movie_ticket_booking_service.service.TheaterService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping("/all-screens")
    public ResponseEntity<List<ScreenDTO>> getScreensByTheater(@RequestParam Long theaterId){
        List<ScreenDTO> response = theaterService.getScreensForTheater(theaterId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTheater(@RequestBody TheaterDTO theaterDTO){
        theaterService.addTheater(theaterDTO);
        return new ResponseEntity<>("added theater to city", HttpStatus.CREATED);
    }

    @PostMapping("/save/screens")
    public ResponseEntity<String> addScreensToTheater(@RequestBody ScreenDTO screenDTO){
        theaterService.addScreensToTheater(screenDTO);
        return new ResponseEntity<>("added screens to theater", HttpStatus.CREATED);
    }
}
