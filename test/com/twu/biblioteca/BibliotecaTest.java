package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
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
    public void shouldShowListOfAvailableMovies(){
        boolean availableMovies = this.biblioteca.getAvailableMovies().stream().anyMatch(movie -> movie.isAvailable());
        assertEquals(true, availableMovies);
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
    public void shouldMakeBookUnavailableAfterCheckout() throws BookNotFoundException {
        this.biblioteca.checkoutBook("Harry Potter");
        Book book = this.biblioteca.findBook("Harry Potter");
        boolean isBookAvailable = book.isAvailable();
        assertThat(isBookAvailable, is(false));
    }

    @Test
    public void shouldNotShowCheckedOutBookOnBookList(){
        Book beforeCheckout = checkoutHarryPotterBook();
        assertThat(this.biblioteca.getAvailableBooks(), not(hasItem(beforeCheckout)));
    }

    private Book checkoutHarryPotterBook() {
        Book beforeCheckout = this.biblioteca.getBooks().stream().filter(book -> book.getTitle().equals("Harry Potter")).findFirst().get();
        this.biblioteca.checkoutBook("Harry Potter");
        return beforeCheckout;
    }

    @Test
    public void shouldNotifyIfBookIsUnavailable(){
        Book beforeCheckout = checkoutHarryPotterBook();
        assertEquals(this.biblioteca.checkoutBook("Harry Potter"), "That book is not available!");
    }

    @Test
    public void shouldReturnBookToTheRightLibrary(){
        checkoutHarryPotterBook();
        assertEquals(this.biblioteca.returnBook("Harry Potter"), "Thank you for returning the book!");
    }

    @Test
    public void shouldNotifyIfBookDoesNotBelongToLibrary(){
        assertEquals(this.biblioteca.returnBook("Twilight"), "That is not a valid book to return.");
    }
}