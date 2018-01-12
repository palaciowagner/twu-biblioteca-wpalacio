package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        Biblioteca biblioteca = createBiblioteca();
        this.menu = new Menu(biblioteca);
    }

    @Test
    public void shouldShowListBookOptions(){
        assertEquals("1. List of Books\n", this.menu.showOptions());
    }

    @Test
    public void shouldShowListOfBooksWhenEnterOne(){
        MenuOption menuOption = this.menu.findOption(1);
        assertEquals(ListBooksOption.class, menuOption.getClass());
    }

    @Test
    public void shouldRaiseErrorWhenOptionDoesntExist(){

            MenuOption menuOption = this.menu.findOption(2);
            fail();


    }

    private static Biblioteca createBiblioteca() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book harry_potter = new Book("Harry Potter", "J.K. Rowling", "1997");
        Book lord_of_the_rings = new Book("Lord of the rings", "J.R.R. Tolkien", "1980");
        books.add(harry_potter);
        books.add(lord_of_the_rings);
        return new Biblioteca(books);
    }


}