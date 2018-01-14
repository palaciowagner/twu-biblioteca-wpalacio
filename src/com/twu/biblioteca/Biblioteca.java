package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
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

    public String checkoutBook(String title) {
        String returnMessage = "That book is not available!";

        try {
            Book book = findBook(title);
            if (book.isAvailable()) {
                book.setAvailable(false);
                returnMessage = "Thank you! Enjoy the book!";
            }
        } catch (BookNotFoundException e) {
            return e.getMessage();
        }
        return returnMessage;
    }

    public Book findBook(String title) throws BookNotFoundException {
        try {
            return this.getBooks()
                    .stream()
                    .filter(book -> book.getTitle()
                            .equals(title))
                    .findFirst()
                    .get();

        }
        catch (NoSuchElementException ex){
            throw new BookNotFoundException();
        }
    }
}
