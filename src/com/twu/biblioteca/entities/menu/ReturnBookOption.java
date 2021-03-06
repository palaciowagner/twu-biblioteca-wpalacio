package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

public class ReturnBookOption extends MenuOption {
    public ReturnBookOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "Return Book", biblioteca);
    }

    @Override
    public void view() {
        String bookTitle = CliHelper.getUserInput("Enter the title of the book you want to return: ");
        CliHelper.println(this.getBiblioteca().returnItem(bookTitle));
    }
}
