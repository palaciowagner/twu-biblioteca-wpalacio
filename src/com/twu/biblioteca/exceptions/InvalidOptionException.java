package com.twu.biblioteca.exceptions;

import java.util.NoSuchElementException;

public class InvalidOptionException extends NoSuchElementException{
    public InvalidOptionException(){
        super("Select a valid option!");
    }
}
