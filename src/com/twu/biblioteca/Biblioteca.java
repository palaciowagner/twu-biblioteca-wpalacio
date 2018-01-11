package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books){
        this.setBooks(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return this.books.stream().filter(book -> book.isAvailable()).collect(Collectors.<Book> toList());
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
