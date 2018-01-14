package com.twu.biblioteca;

import com.twu.biblioteca.entities.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book bookTest;
    @Before
    public void setUp(){
        this.bookTest = new BookTestBuilder().build();
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