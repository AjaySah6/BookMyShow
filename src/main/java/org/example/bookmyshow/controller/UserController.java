package org.example.bookmyshow.controller;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.UserSignUpRequestDto;
import org.example.bookmyshow.dtos.UserSignUpResponseDto;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Request Dto will have same attributes as needed signUp();
    public UserSignUpResponseDto signUp (UserSignUpRequestDto requestDto){
        UserSignUpResponseDto responseDto = new UserSignUpResponseDto();

        try {
            User user = userService.signUp(requestDto.getEmail(), requestDto.getPassword());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setUserId(user.getId());

        }catch(Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
