package com.twu.biblioteca;

import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

    private List<Book> books;

    public Biblioteca(List<Book> books){
        this.setBooks(books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return this.books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void checkoutBook(String title) {
        findBook(title).setAvailable(false);
        System.out.println("Thank you! Enjoy the book!");
    }

    public Book findBook(String title) {
        return this.getBooks()
                .stream()
                .filter(book -> book.getTitle()
                        .equals(title))
                .findFirst()
                .get();
    }
}
