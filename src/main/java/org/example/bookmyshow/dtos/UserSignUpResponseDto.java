package org.example.bookmyshow.dtos;

import org.example.bookmyshow.dtos.ResponseStatus;

import lombok.Data;

@Data
public class UserSignUpResponseDto {
    private ResponseStatus status;
    private Long userId;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
