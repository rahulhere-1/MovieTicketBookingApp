package com.example.movie_ticket_booking_service.controller;

import com.example.movie_ticket_booking_service.dto.UserDetailsDTO;
import com.example.movie_ticket_booking_service.model.Customer;
import com.example.movie_ticket_booking_service.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signup")
    ResponseEntity<String> userSignUp(@RequestBody UserDetailsDTO userDetailsDTO){
        Customer user = new Customer();
        user.setUsername(userDetailsDTO.getUsername());
        user.setPassword(encoder.encode(userDetailsDTO.getPassword()));
        user.setRole(userDetailsDTO.getRole());
        userDao.save(user);
        return new ResponseEntity<>("signed up successfully", HttpStatus.CREATED);
    }

    @PostMapping("/user")
    ResponseEntity<String> userLogin(@RequestBody UserDetailsDTO userDetailsDTO){
        Customer user = userDao.findByUsername(userDetailsDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("no user found"));
        return new ResponseEntity<>("logged in successfully", HttpStatus.CREATED);
    }

}
