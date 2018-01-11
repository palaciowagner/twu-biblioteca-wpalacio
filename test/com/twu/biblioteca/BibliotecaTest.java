package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));

        ArrayList<Book> books = new ArrayList<Book>();
        Book harry_potter = new Book("Harry Potter");
        Book lord_of_the_rings = new Book("Lord of the rings");
        books.add(harry_potter);
        books.add(lord_of_the_rings);

        this.biblioteca = new Biblioteca(books);
    }


    @Test
    public void shouldShowListOfAvailableBooks(){
        List<Book> availableBooks = this.biblioteca.getAvailableBooks();
        for (Book book : availableBooks){
            assertEquals(book.isAvailable(), true);
        }
    }

}