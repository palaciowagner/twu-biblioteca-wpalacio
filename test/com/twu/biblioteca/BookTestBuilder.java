package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;

public class BookTestBuilder {

    private String title = "Harry Potter";
    private String author = "J.K. Rowling";
    private String publishedYear = "1997";
    private boolean isAvailable = true;

    public BookTestBuilder WithIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
        return this;
    }

    public BookTestBuilder WithTitle(String title){
        this.title = title;
        return this;
    }

    public BookTestBuilder WithAuthor(String author){
        this.author = author;
        return this;
    }

    public BookTestBuilder WithPublishedYear(String publishedYear){
        this.publishedYear = publishedYear;
        return this;
    }
    public Book build(){
        return new Book(title, author,publishedYear, isAvailable);
    }
}
