package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.ItemNotFoundException;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Before
    public void setUp() {

        this.biblioteca = new BibliotecaTestBuilder().build();
    }

    @Test
    public void shouldShowListOfAvailableBooks(){
        boolean availableBooks = this.biblioteca.getItems().allAvailable(Book.class).stream().anyMatch(book -> book.isAvailable());
        assertEquals(true, availableBooks);
    }

    @Test
    public void shouldShowListOfAvailableMovies(){
        boolean availableMovies = this.biblioteca.getItems().allAvailable(Movie.class).stream().anyMatch(movie -> movie.isAvailable());
        assertEquals(true, availableMovies);
    }

    @Test
    public void shouldNotShowCheckedOutBooks(){
        this.biblioteca = new BibliotecaTestBuilder().WithItems(new ArrayList<Item>() {{
            add(new BookTestBuilder().WithIsAvailable(false).build());
        }}).build();
        boolean unavailableBooks = this.biblioteca.getItems().allAvailable(Book.class).size() < (this.biblioteca.getAllItems().size());
        assertEquals(true, unavailableBooks);
    }

    @Test
    public void shouldMakeBookUnavailableAfterCheckout() throws ItemNotFoundException {
        this.biblioteca.checkout("Harry Potter");
        Book book = (Book)this.biblioteca.getItems().find("Harry Potter");
        boolean isBookAvailable = book.isAvailable();
        assertThat(isBookAvailable, is(false));
    }

    @Test
    public void shouldNotShowCheckedOutBookOnBookList(){
        Book beforeCheckout = checkoutHarryPotterBook();
        assertThat(this.biblioteca.getItems().allAvailable(Book.class), not(hasItem(beforeCheckout)));
    }

    private Book checkoutHarryPotterBook() {
        Book beforeCheckout = (Book)this.biblioteca
                .getItems()
                .allAvailable(Book.class)
                .stream()
                .filter(book -> book.getTitle().equals("Harry Potter"))
                .findFirst()
                .get();
        this.biblioteca.checkout("Harry Potter");
        return beforeCheckout;
    }

    @Test
    public void shouldNotifyIfBookIsUnavailable(){
        Book beforeCheckout = checkoutHarryPotterBook();
        assertEquals(this.biblioteca.checkout("Harry Potter"), "That book is not available!");
    }

    @Test
    public void shouldReturnBookToTheRightLibrary(){
        checkoutHarryPotterBook();
        assertEquals(this.biblioteca.returnItem("Harry Potter"), "Thank you for returning the book!");
    }

    @Test
    public void shouldNotifyIfBookDoesNotBelongToLibrary(){
        assertEquals(this.biblioteca.returnItem("Twilight"), "Sorry, we could not find this item.");
    }

    @Test
    public void shouldSignIn() throws UserNotFoundException{
        assertTrue(this.biblioteca.signIn("1234-5678", "test"));
    }

    @Test
    public void shouldFailSignInIfPasswordIsIncorrect() throws UserNotFoundException{
        assertFalse(this.biblioteca.signIn("1234-5678", "abrico"));
    }

    @Test
    public void shouldRaiseErrorWhenUserIsNotFound(){
        try{
            this.biblioteca.signIn("4244-2323", "testee");
            fail();
        }
        catch (UserNotFoundException ex){

        }
    }
}