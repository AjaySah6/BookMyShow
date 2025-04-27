package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}
