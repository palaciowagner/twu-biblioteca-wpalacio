package com.twu.biblioteca.Menu;

public class ListBooksOption extends MenuOption {

    public ListBooksOption(int optionNumber, String optionText){
        super(optionNumber, optionText);
    }
    @Override
    public String show() {
        return this.getOptionNumber() + ". "+ this.getOptionText();
    }
}
