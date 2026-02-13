package com.example.movie_ticket_booking_service.model;

import com.example.movie_ticket_booking_service.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @Column
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToMany(mappedBy = "seats")
    private List<Booking> bookings;

    public boolean isBookedForShow(Long showId) {
        if (bookings == null || showId==null) return false;
        for (Booking booking : bookings) {
            if (booking.getShow() != null && booking.getShow().getId()== showId) {
                return true; // Seat already booked for this show
            }
        }
        return false;
    }


}
