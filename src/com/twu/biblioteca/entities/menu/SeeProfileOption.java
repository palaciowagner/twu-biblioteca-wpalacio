package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;

public class SeeProfileOption extends MenuOption {
    public SeeProfileOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "See my profile" ,biblioteca);
    }

    @Override
    public void view() {
        this.getBiblioteca().getLoggedInUser().getProfile();
    }
}
