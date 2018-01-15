package com.twu.biblioteca;

import com.twu.biblioteca.entities.*;
import com.twu.biblioteca.entities.menu.Menu;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import com.twu.biblioteca.helpers.CliHelper;

public class BibliotecaApp {

    private Menu menu;

    public static void main(String[] args) {
        Biblioteca biblioteca =  createBiblioteca();
        Menu menu = new Menu(biblioteca);

        if (signIn(biblioteca)) {
            showWelcomeMessage();
            menu.printOptions();
            menu.getUserOption();
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("===== Welcome to TWU Biblioteca =====");
    }

    private static boolean signIn(Biblioteca biblioteca){
        try{
            String libraryNumber = CliHelper.getUserInput("Library Number");
            String password = CliHelper.getUserInput("Password:");
            return biblioteca.signIn(libraryNumber, password);

        }
        catch (UserNotFoundException ex){
            CliHelper.println(ex.getMessage());
            return false;
        }
    }

    private static Biblioteca createBiblioteca() {
        BibliotecaItems items = new BibliotecaItems();
        Book harry_potter = new Book("Harry Potter", "J.K. Rowling", "1997", true);
        Book lord_of_the_rings = new Book("Lord of the rings", "J.R.R. Tolkien", "1980", true);
        Movie star_wars = new Movie("Star Wars", "1980", "George Lucas", 8,true);
        items.add(harry_potter);
        items.add(lord_of_the_rings);
        items.add(star_wars);

        UserAccounts users = new UserAccounts();
        users.addUser(new User("1234-5678", "test"));
        return new Biblioteca(items, users);
    }

}
