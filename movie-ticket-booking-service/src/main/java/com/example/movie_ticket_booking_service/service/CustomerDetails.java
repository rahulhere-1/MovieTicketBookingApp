package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.model.Customer;
import com.example.movie_ticket_booking_service.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetails implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username NOT FOUND"));
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUsername(),user.getPassword(),authorityList);

    }
}
