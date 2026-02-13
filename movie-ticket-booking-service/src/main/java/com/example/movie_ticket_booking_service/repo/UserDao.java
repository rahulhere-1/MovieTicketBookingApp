package com.example.movie_ticket_booking_service.repo;

import com.example.movie_ticket_booking_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUsername(String username);
}
