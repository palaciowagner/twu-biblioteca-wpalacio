package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;

public abstract class MenuOption {
    private int optionNumber;
    private String optionText;
    private Biblioteca biblioteca;
    private boolean quitApp;

    public MenuOption(int optionNumber, String optionText, Biblioteca biblioteca){
        this.setOptionNumber(optionNumber);
        this.setOptionText(optionText);
        this.setBiblioteca(biblioteca);
        this.setQuitApp(false);
    }

    public String print(){
        return this.getOptionNumber() + ". "+ this.getOptionText();
    }

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

    public boolean isQuitApp() {
        return quitApp;
    }

    public void setQuitApp(boolean quitApp) {
        this.quitApp = quitApp;
    }
}
