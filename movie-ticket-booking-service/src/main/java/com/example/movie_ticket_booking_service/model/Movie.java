package com.example.movie_ticket_booking_service.model;

import com.example.movie_ticket_booking_service.enums.Genre;
import com.example.movie_ticket_booking_service.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movie")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private Integer duration;

    @Column
    private LocalDateTime releaseDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column()
    @Enumerated(EnumType.STRING)
    private Status status =  Status.ACTIVE;

}
