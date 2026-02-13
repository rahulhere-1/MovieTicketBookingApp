package com.example.movie_ticket_booking_service.repo;

import com.example.movie_ticket_booking_service.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {
}
