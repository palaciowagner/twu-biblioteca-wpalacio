package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.helpers.CliHelper;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BibliotecaApp {

    private Menu menu;


    public static void main(String[] args) {
        Biblioteca biblioteca =  createBiblioteca();
        Menu menu = new Menu(biblioteca);

        showWelcomeMessage();
        printMenuOptions(menu);
        chooseOption(menu);

        //listBooks(biblioteca);
    }

    private static void chooseOption(Menu menu) {
        String number = CliHelper.getUserInput("Option: ");
        menu.chooseOption(parseInt(number));

    }

    private static void printMenuOptions(Menu menu) {
        CliHelper.print("Please, choose an option: \n");
        menu.show();
    }

    private static void showWelcomeMessage() {
        System.out.println("===== Welcome to TWU Biblioteca =====");
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
