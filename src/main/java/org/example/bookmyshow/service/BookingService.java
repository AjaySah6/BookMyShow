package org.example.bookmyshow.service;

import org.example.bookmyshow.exceptions.*;
import org.example.bookmyshow.models.Booking;
import org.example.bookmyshow.models.*;
import org.example.bookmyshow.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculatorService priceCalculatorService;


    public BookingService(ShowSeatRepository showSeatRepository,
                          UserRepository userRepository,
                          ShowRepository showRepository,
                          BookingRepository bookingRepository,
                          PriceCalculatorService priceCalculatorService) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking issueTicket(Long userId, Long showId, List<Long> showSeatIds) throws Exception {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found enter valid user details");
        }

        Optional<Show> show = showRepository.findById(showId);
        if (show.isEmpty()) {
            throw new ShowNotFoundException("Enter valid show details");
        }


        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if (!isSeatAvailableForBooking(showSeat)) {
                throw new ShowSeatNotAvailableException("Seat is not available, please try another Show Seat");
            }
        }

        // after showSeat found to be available, updating showSeat and saving to DB
        for(ShowSeat showSeat : showSeats) {
            showSeat.setBlockedAt(new Date());  // update the timer
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }
        Booking booking = new Booking();
        booking.setUser(user.get());
        booking.setShow(show.get());
        booking.setBookedAt(new Date());
        booking.setShowseats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show.get()));

        return bookingRepository.save(booking);
    }

    private boolean isSeatAvailableForBooking(ShowSeat showSeat){
        long BlockDurationMinutes = 15;
        if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))){
            return true;
        }
        if((showSeat.getShowSeatStatus()== ShowSeatStatus.BLOCKED) &&
        Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes()>BlockDurationMinutes){
            return true;
        }
        return false;
    }



}
