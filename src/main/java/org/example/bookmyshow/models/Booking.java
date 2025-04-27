package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data                                  // @Getter + @Setter
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Show show;

    private Date bookedAt;

    @ManyToOne
    private User user;    // Booking done by

    @ManyToMany
    private List<ShowSeat> showseats;

    private int amount;
    //private ShowSeatType showSeatType; // To get the price

    @OneToMany                          //One Booking ➔ Many Payments , Pay part now, and pay the rest later (split payment).
    private List<Payment> payments;
}
