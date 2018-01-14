package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;

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
        BibliotecaItems books = new BibliotecaItems();
        Book harry_potter = new Book("Harry Potter", "J.K. Rowling", "1997", true);
        Book lord_of_the_rings = new Book("Lord of the rings", "J.R.R. Tolkien", "1980", true);
        books.add(harry_potter);
        books.add(lord_of_the_rings);
        return new Biblioteca(books);
    }

}
