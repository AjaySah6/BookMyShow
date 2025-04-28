package org.example.bookmyshow.exceptions;

public class ShowSeatNotAvailableException extends Exception{
    public ShowSeatNotAvailableException(){}
    public ShowSeatNotAvailableException(String message){
        super(message);
    }
}
