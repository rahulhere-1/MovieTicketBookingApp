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
@Table(name = "tbl_theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    @Column
    private String theaterName;

    @Column
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private List<Screen> screens;

}
