package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.dto.ScreenDTO;
import com.example.movie_ticket_booking_service.dto.TheaterDTO;
import com.example.movie_ticket_booking_service.enums.SeatType;
import com.example.movie_ticket_booking_service.exception.TheaterNotFoundException;
import com.example.movie_ticket_booking_service.model.Screen;
import com.example.movie_ticket_booking_service.model.Seat;
import com.example.movie_ticket_booking_service.model.Theater;
import com.example.movie_ticket_booking_service.repo.ScreenRepository;
import com.example.movie_ticket_booking_service.repo.SeatRepository;
import com.example.movie_ticket_booking_service.repo.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {


    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void addTheater(TheaterDTO dto){
        Theater theater = new Theater();
        theater.setTheaterName(dto.getTheaterName());
        theater.setCity(dto.getCity());
        theaterRepository.save(theater);
    }

    @Override
    public void addScreensToTheater(ScreenDTO screenDTO){
        Theater theater = theaterRepository.findById(screenDTO.getTheaterId()).orElseThrow(() -> new TheaterNotFoundException("Theater NOT FOUND"));
        Screen screen = new Screen();
        screen.setScreenName(screenDTO.getScreenName());
        screen.setCapacity(screenDTO.getCapacity());
        screen.setTheater(theater);
        screenRepository.save(screen);
        createSeatsForScreen(screen);
        theaterRepository.save(theater);
    }

    private void createSeatsForScreen(Screen screen) {

        List<Seat> seats = new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=1;j<=8;j++){
                Seat seat = new Seat();
                StringBuilder sb = new StringBuilder("A"+i).append(Integer.toString(j));
                seat.setSeatNumber(sb.toString());
                seat.setSeatType(SeatType.CLASSIC);
                seat.setScreen(screen);
                seats.add(seat);
            }
        }
        for(int i=5;i<8;i++){
            for(int j=1;j<=8;j++){
                Seat seat = new Seat();
                StringBuilder sb = new StringBuilder("A"+i).append(Integer.toString(j));
                seat.setSeatNumber(sb.toString());
                seat.setSeatType(SeatType.PREMIUM);
                seat.setScreen(screen);
                seats.add(seat);
            }
        }
        for(int i=8;i<9;i++){
            for(int j=1;j<=8;j++){
                Seat seat = new Seat();
                StringBuilder sb = new StringBuilder("A"+i).append(Integer.toString(j));
                seat.setSeatNumber(sb.toString());
                seat.setSeatType(SeatType.GOLD);
                seat.setScreen(screen);
                seats.add(seat);
            }
        }
        seatRepository.saveAll(seats);
    }

    @Override
    public List<ScreenDTO> getScreensForTheater(Long theaterId){
        List<Screen> screenList = theaterRepository.findById(theaterId).orElseThrow(() -> new TheaterNotFoundException("Theater NOT Found to add Screens")).getScreens();
        List<ScreenDTO> response = new ArrayList<>();
        for(Screen screen: screenList){
            ScreenDTO dto = new ScreenDTO();
            dto.setScreenId(screen.getScreenId());
            dto.setScreenName(screen.getScreenName());
            dto.setCapacity(screen.getCapacity());
            dto.setSeatList(screen.getSeats());
            response.add(dto);
        }
        return response;
    }


}
