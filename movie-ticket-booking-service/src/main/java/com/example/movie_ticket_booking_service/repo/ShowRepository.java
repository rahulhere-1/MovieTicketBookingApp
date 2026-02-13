package com.example.movie_ticket_booking_service.repo;

import com.example.movie_ticket_booking_service.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {

    List<Show> findByMovieId(Long movieId);
}
