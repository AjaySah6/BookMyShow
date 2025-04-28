package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter // Adds getters for all fields
@Setter // Adds setters for all fields
public class SeatType extends BaseModel{
    private String name;
}
