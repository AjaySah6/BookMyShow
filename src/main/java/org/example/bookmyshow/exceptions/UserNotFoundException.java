package org.example.bookmyshow.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {}
    public UserNotFoundException(String message) {
        super(message);
    }
}
