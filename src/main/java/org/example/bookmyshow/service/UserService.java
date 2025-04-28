package org.example.bookmyshow.service;

import org.example.bookmyshow.exceptions.UserAccountException;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) throws UserAccountException {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            throw new UserAccountException("User account already exists");
        }
        User user = new User();
        user.setEmail(email);

        // Hash the password
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));


        // Save the user to DB
        return userRepository.save(user);
    }
}
