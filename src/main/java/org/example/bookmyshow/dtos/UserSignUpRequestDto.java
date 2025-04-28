package org.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class UserSignUpRequestDto {
    private String email;
    private String password;
}
