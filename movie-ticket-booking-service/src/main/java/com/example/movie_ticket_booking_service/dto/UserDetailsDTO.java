package com.example.movie_ticket_booking_service.dto;

import lombok.Data;

@Data
public class UserDetailsDTO {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private String role;
}
