package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

public class QuitOption extends MenuOption {
    public QuitOption(int option, Biblioteca biblioteca) {
        super(option, "Quit", biblioteca );
        setQuitApp(true);
    }

    @Override
    public void view() {
        CliHelper.print("Thanks for coming!");
    }
}
