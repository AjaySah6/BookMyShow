package org.example.bookmyshow.exceptions;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(){}
    public ShowNotFoundException(String message){
        super(message);
    }
}
