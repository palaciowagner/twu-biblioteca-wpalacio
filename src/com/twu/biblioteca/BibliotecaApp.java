package com.twu.biblioteca;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.BibliotecaItems;
import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.entities.menu.Menu;

public class BibliotecaApp {

    private Menu menu;


    public static void main(String[] args) {
        Biblioteca biblioteca =  createBiblioteca();
        Menu menu = new Menu(biblioteca);

        showWelcomeMessage();
        menu.printOptions();
        menu.getUserOption();
    }

    private static void showWelcomeMessage() {
        System.out.println("===== Welcome to TWU Biblioteca =====");
    }

    private static Biblioteca createBiblioteca() {
        BibliotecaItems items = new BibliotecaItems();
        Book harry_potter = new Book("Harry Potter", "J.K. Rowling", "1997", true);
        Book lord_of_the_rings = new Book("Lord of the rings", "J.R.R. Tolkien", "1980", true);
        Movie star_wars = new Movie("Star Wars", "1980", "George Lucas", 8,true);
        items.add(harry_potter);
        items.add(lord_of_the_rings);
        items.add(star_wars);
        return new Biblioteca(items);
    }

}
