package com.twu.biblioteca.exceptions;

public class UserNotFoundException extends Throwable {

    public UserNotFoundException(){
        super("Sorry, this user was not found. Try again.");
    }
}
