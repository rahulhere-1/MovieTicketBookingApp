package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.dto.MovieDTO;
import com.example.movie_ticket_booking_service.dto.ShowDTO;
import com.example.movie_ticket_booking_service.exception.MovieNotFoundException;
import com.example.movie_ticket_booking_service.exception.ShowNotFoundException;
import com.example.movie_ticket_booking_service.exception.UnableToCreateShowException;
import com.example.movie_ticket_booking_service.model.Movie;
import com.example.movie_ticket_booking_service.model.Show;
import com.example.movie_ticket_booking_service.repo.MovieRepository;
import com.example.movie_ticket_booking_service.repo.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ShowDTO getShowDetails(Long id){
        Show show = showRepository.findById(id).orElseThrow(() -> new ShowNotFoundException("Show NOT FOUND"));
        ShowDTO dto = new ShowDTO();
        dto.setShowTime(show.getTime());
        dto.setShowId(show.getId());
        Movie movie = show.getMovie();
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getId());
        movieDTO.setMovieName(movie.getName());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setGenre(movie.getGenre());
        dto.setMovieDTO(movieDTO);
        return dto;
    }

    @Override
    public ShowDTO getShowDetailsByMovieId(Long movieId){
        List<Show> showList = showRepository.findByMovieId(movieId);
        Movie movie = showList.get(0).getMovie();
        ShowDTO dto = new ShowDTO();
        List<ShowDTO> showDtoList = new ArrayList<ShowDTO>();
        for(Show show : showList){
            ShowDTO showDto = new ShowDTO();
            showDto.setShowTime(show.getTime());
            showDto.setShowId(show.getId());
            showDtoList.add(showDto);
        }
        dto.setShowDtoList(showDtoList);
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getId());
        movieDTO.setMovieName(movie.getName());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setGenre(movie.getGenre());
        dto.setMovieDTO(movieDTO);
        return dto;
    }

    @Override
    public void createShowTime(ShowDTO showDTO){
        Long movieId = showDTO.getMovieId();
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not Found"));
        Show show  = new Show();
        if(showDTO.getShowTime()==null){
            throw new UnableToCreateShowException("Show time not mentioned");
        }
        show.setTime(showDTO.getShowTime());
        show.setMovie(movie);
        showRepository.save(show);
    }
    @Override
    public void deleteByShowId(Long showId){
        showRepository.deleteById(showId);
    }


}
