package com.twu.biblioteca.Menu;

public abstract class MenuOption {
    private int optionNumber;
    private String optionText;

    public MenuOption(int optionNumber, String optionText){
        this.setOptionNumber(optionNumber);
        this.setOptionText(optionText);
    }

    public abstract String show();

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
}
