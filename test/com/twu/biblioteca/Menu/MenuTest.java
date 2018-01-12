package com.twu.biblioteca.Menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldShowListBookOptions(){
        Menu menu = new Menu();
        assertEquals("1. List of Books", menu.options());
    }


}