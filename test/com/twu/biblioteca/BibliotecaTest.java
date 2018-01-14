package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Test
    public void shouldNotShowCheckedOutBooks(){
        this.biblioteca = new BibliotecaTestBuilder().WithBooks(new ArrayList<Book>() {{
            add(new BookTestBuilder().WithIsAvailable(false).build());
        }}).build();
        boolean unavailableBooks = this.biblioteca.getAvailableBooks().size() < (this.biblioteca.getBooks()).size();
        assertEquals(true, unavailableBooks);
    }

    @Test
    public void shouldMakeBookUnavailableAfterCheckout(){
        this.biblioteca.checkoutBook("Harry Potter");
        Book book = this.biblioteca.findBook("Harry Potter");
        boolean isBookAvailable = book.isAvailable();
        assertThat(isBookAvailable, is(false));
    }
}