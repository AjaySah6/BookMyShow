package org.example.bookmyshow;

import org.example.bookmyshow.controller.UserController;
import org.example.bookmyshow.dtos.UserSignUpRequestDto;
import org.example.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BmsApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserSignUpRequestDto userSignUpRequestDto = new UserSignUpRequestDto();
        userSignUpRequestDto.setEmail("test@gmail.com");
        userSignUpRequestDto.setPassword("test@123");

        userController.signUp(userSignUpRequestDto);
    }
}

//