package com.example.movie_ticket_booking_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String role;

}
