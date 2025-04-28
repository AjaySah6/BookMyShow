package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter // Adds getters for all fields
@Setter // Adds setters for all fields
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private int price;

}
