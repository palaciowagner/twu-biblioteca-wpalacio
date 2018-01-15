package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        this.menu = new MenuTestBuilder().build();
        System.setOut(new PrintStream(outContent));
    }

    @After
     public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldShowListBookOptions(){
        assertThat(this.menu.showOptions(), containsString("List of Books\n"));
    }

    @Test
    public void shouldShowListOfBooksWhenEnterOne(){
        MenuOption menuOption = this.menu.findOption(1);
        assertEquals(ListBooksOption.class, menuOption.getClass());
    }

    @Test
    public void shouldRaiseErrorWhenOptionDoesNotExist(){
        try {
            MenuOption menuOption = this.menu.findOption(10);
            fail();
        }
        catch (InvalidOptionException ex){}
    }

    @Test
    public void shouldShowQuitOption(){
        assertThat(this.menu.showOptions(), containsString("Quit\n"));
    }

    @Test
    public void shouldShowCheckoutBookOption(){
        assertThat(this.menu.showOptions(), containsString("Checkout Book\n"));
    }

    @Test
    public void shouldShowReturnBookOption(){
        assertThat(this.menu.showOptions(), containsString("Return Book\n"));
    }

    @Test
    public void shouldShowListMoviesOption(){
        assertThat(this.menu.showOptions(), containsString("List Movies\n"));
    }

    @Test
    public void shouldShowCheckoutMovieOption(){
        assertThat(this.menu.showOptions(), containsString("Checkout Movie\n"));
    }


}