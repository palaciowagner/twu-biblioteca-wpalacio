package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

public class CheckoutBookOption extends MenuOption {
    public CheckoutBookOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "Checkout Book", biblioteca);
    }

    @Override
    public void view() {
        String bookTitle = CliHelper.getUserInput("Enter the title of the book you want to checkout: ");
        CliHelper.println(this.getBiblioteca().checkout(bookTitle));
    }
}
