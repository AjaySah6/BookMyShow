package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus = ShowSeatStatus.AVAILABLE; //AVAILABLE when a new ShowSeat is created

    private Date blockedAt;
}
