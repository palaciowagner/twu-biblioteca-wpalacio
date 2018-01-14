package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;

public class ReturnBookOption extends MenuOption {
    public ReturnBookOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "Return Book", biblioteca);
    }

    @Override
    public void view() {

    }
}
