package com.example.movie_ticket_booking_service.repo;

import com.example.movie_ticket_booking_service.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
}
