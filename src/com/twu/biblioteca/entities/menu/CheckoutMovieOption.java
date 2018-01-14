package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

public class CheckoutMovieOption extends MenuOption {

    public CheckoutMovieOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "Checkout Movie", biblioteca);
    }

    @Override
    public void view() {
        String movieTitle = CliHelper.getUserInput("Enter the title of the movie you want to checkout: ");
        CliHelper.println(this.getBiblioteca().checkout(movieTitle));

    }
}
