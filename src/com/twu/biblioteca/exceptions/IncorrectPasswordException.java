package com.twu.biblioteca.exceptions;

public class IncorrectPasswordException extends Throwable {
    public IncorrectPasswordException(){
        super("Incorrect password.");
    }
}
