package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.awt.print.Book;

@Data // @Getter + @Setter
@Entity
public class Region extends BaseModel{
    private String region;
}
