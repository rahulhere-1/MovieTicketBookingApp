package com.example.movie_ticket_booking_service.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            Environment env = getEnvironment();
            if(env!=null){
                try {
                    String secret = env.getProperty("JWT_SECRET","lj2h50a9uo2DF3lj2h5efg3D49uo23ljER2h5g5456GF45yo233453");
                    SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
                    String jwtToken = Jwts.builder().issuer("movie ticket booking").subject("JWT Token")
                            .claim("username",authentication.getName())
                            .claim("authorities",authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                                    .collect(Collectors.joining(",")))
                            .issuedAt(new Date())
                            .expiration(new Date(new Date().getTime() + 3000000))
                            .signWith(secretKey)
                            .compact();
                    response.setHeader("Authorization",jwtToken);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/user");
    }
}
