package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaTestBuilder {

    private List<Book> books = new ArrayList<>();

    public BibliotecaTestBuilder WithBooks(List<Book> books){
        this.books = books;
        return this;
    }

    public Biblioteca build(){
        this.books.add(new BookTestBuilder().build());
        this.books.add(new BookTestBuilder().WithTitle("Lord of the rings").WithAuthor("J.R.R. Tolkien").WithPublishedYear("1980").build());
        return new Biblioteca(books);
    }
}
