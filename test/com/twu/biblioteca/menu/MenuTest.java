package com.twu.biblioteca.menu;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        this.menu = new MenuTestBuilder().build();
    }

    @Test
    public void shouldShowListBookOptions(){
        assertThat(this.menu.showOptions(), containsString("1. List of Books\n"));
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
        assertThat(this.menu.showOptions(), containsString("2. Quit\n"));
    }

    @Test
    public void shouldStopAppWhenQuit(){

    }

}