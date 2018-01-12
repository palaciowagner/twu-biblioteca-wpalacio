package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;

public class QuitOption extends MenuOption {
    public QuitOption(int option, Biblioteca biblioteca) {
        super(option, "Quit", biblioteca );
    }

    @Override
    public void view() {

    }
}
