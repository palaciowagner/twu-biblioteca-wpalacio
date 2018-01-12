package com.twu.biblioteca.menu;

import java.util.NoSuchElementException;

public class InvalidOptionException extends NoSuchElementException{
    public InvalidOptionException(String message){
        super(message);
    }
}
