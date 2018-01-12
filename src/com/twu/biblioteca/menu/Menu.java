package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {

    private List<MenuOption> menuOptions;

    public Menu(Biblioteca biblioteca){
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, biblioteca));
        }};
    }

    public void show(){
        CliHelper.print(showOptions());
    }

    public String showOptions() {
        StringBuilder options =  new StringBuilder();
        this.menuOptions.forEach(option -> options.append(option.print() + "\n"));
        return options.toString();
    }

    public void chooseOption(int number){
        findOption(number).view();
    }

    public MenuOption findOption(int number){
        MenuOption option = findOptionByNumber(number);
        return option;
    }

    private MenuOption findOptionByNumber(int number) {
        Optional<MenuOption> menuOption =  this.menuOptions.stream()
                                                            .filter(option-> option.getOptionNumber() == number)
                                                            .findFirst();
        return menuOption.get();
    }
}
