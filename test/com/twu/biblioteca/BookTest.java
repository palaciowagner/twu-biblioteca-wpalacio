package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book bookTest;
    @Before
    public void setUp(){
        this.bookTest = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "1997");
    }
    @Test
    public void shouldShowAuthorsName(){
        assertEquals(this.bookTest.getAuthor(), "J.K. Rowling");
    }

    @Test
    public void shouldShowPublishedYear(){
        assertEquals(this.bookTest.getPublishedYear(), "1997");
    }

}