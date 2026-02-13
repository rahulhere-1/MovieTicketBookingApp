package com.example.movie_ticket_booking_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_screen")
public class Screen {

    @Id
    @Column(name = "screen_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    @Column
    private String screenName;

    @Column
    private int capacity;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screen")
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;



}
