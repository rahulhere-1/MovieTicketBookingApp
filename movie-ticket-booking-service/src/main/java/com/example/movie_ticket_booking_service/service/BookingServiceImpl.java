package com.example.movie_ticket_booking_service.service;

import com.example.movie_ticket_booking_service.model.Booking;
import com.example.movie_ticket_booking_service.model.Seat;
import com.example.movie_ticket_booking_service.repo.BookingRepository;
import com.example.movie_ticket_booking_service.repo.SeatRepository;
import com.example.movie_ticket_booking_service.repo.ShowRepository;
import com.example.movie_ticket_booking_service.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    // Autowire required repositories (UserRepository, ShowRepository, SeatRepository, BookingRepository, etc.)
    @Autowired
    private UserDao userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public boolean bookTicket(Long userId, Long showId, List<Long> seatIds) {
        // 1. Validate user exists
        var user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return false;
        }

        // 2. Validate show exists
        var show = showRepository.findById(showId);
        if (show.isEmpty()) {
            return false;
        }

        // 3. Check seat availability for the show
        List<Seat> seatsToBook = seatRepository.findAllById(seatIds);
        if (seatsToBook.size() != seatIds.size()) {
            return false; // some seats not found
        }

        // assuming Seat entity has a booking status linked to shows
        for (Seat seat : seatsToBook) {
            if (seat.isBookedForShow(showId)) { // Your method to check booking status for a seat in the show
                return false; // seat already booked
            }
        }

        // 4. Create booking records - could be one booking record per seat or grouped (depending on your model)
        var booking = new Booking();
        booking.setUser(user.get());
        booking.setShow(show.get());
        booking.setSeats(seatsToBook);
        booking.setBookingTime(LocalDateTime.now());

        bookingRepository.save(booking);

        // 5. Mark seats as booked for the given show
        //seatsToBook.forEach(seat -> seat.bookForShow(showId));
        seatRepository.saveAll(seatsToBook);

        return true;
    }
}
