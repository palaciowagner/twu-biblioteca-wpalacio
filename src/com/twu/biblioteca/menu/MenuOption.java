package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;

public abstract class MenuOption {
    private int optionNumber;
    private String optionText;
    private Biblioteca biblioteca;

    public MenuOption(int optionNumber, String optionText, Biblioteca biblioteca){
        this.setOptionNumber(optionNumber);
        this.setOptionText(optionText);
        this.setBiblioteca(biblioteca);
    }

    public abstract String print();

    public abstract void view();

    public int getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
