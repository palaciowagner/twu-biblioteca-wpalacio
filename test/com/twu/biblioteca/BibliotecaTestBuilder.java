package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaTestBuilder {

    private List<Book> books = new ArrayList<>();

    public BibliotecaTestBuilder WithBooks(List<Book> books){
        this.books.addAll(books);
        return this;
    }

    public Biblioteca build(){
        Biblioteca biblioteca = new Biblioteca(books);
        this.books.add(new BookTestBuilder().build());
        this.books.add(new BookTestBuilder().WithTitle("Lord of the rings").WithAuthor("J.R.R. Tolkien").WithPublishedYear("1980").build());
        this.books.add(new BookTestBuilder().WithTitle("O Alquimista").WithAuthor("Paulo Coelho").WithPublishedYear("1990").WithIsAvailable(false).build());
        return biblioteca;
    }
}
