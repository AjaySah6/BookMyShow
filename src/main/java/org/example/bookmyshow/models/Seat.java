package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Seat extends BaseModel{
    private String name;

    @ManyToOne
    private SeatType seatType;

    private int rowval;
    private int columnval;
}
