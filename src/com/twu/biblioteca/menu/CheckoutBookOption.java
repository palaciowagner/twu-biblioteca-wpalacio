package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;

public class CheckoutBookOption extends MenuOption {
    public CheckoutBookOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "Checkout Book", biblioteca);
    }

    @Override
    public void view() {

    }
}
