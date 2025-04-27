package org.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Screen extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)    // ----> Stores enum as its ordinal (index) value in DB (e.g., 0, 1).
    @ElementCollection // ---> To create a mapping table
    private List<Feature> features;

}
