package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void setUp() {

        this.biblioteca = new BibliotecaTestBuilder().build();
    }

    @Test
    public void shouldShowListOfAvailableBooks(){
        boolean availableBooks = this.biblioteca.getAvailableBooks().stream().anyMatch(book -> book.isAvailable());
        assertEquals(true, availableBooks);
    }

}