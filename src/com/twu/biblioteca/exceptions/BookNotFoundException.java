package com.twu.biblioteca.exceptions;

public class BookNotFoundException extends Throwable {

    public BookNotFoundException(){
        super("Sorry, this book was not found.");
    }
}
