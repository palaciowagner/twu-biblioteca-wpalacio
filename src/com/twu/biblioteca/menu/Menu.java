package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Menu {

    private List<MenuOption> menuOptions;

    public Menu(Biblioteca biblioteca){
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, biblioteca));
            add(new QuitOption(2, biblioteca));
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

    public void chooseOption(){
        try{
            String number = CliHelper.getUserInput("Option: ");
            findOption(parseInt(number)).view();
        }
        catch (InvalidOptionException ex){
            CliHelper.print("Select a valid option!\n");
            chooseOption();
        }
    }

    public MenuOption findOption(int number) throws InvalidOptionException{
            Optional<MenuOption> option = findOptionByNumber(number);
            if (!option.isPresent()){
                throw new InvalidOptionException();
            }
            return option.get();
    }

    private Optional<MenuOption> findOptionByNumber(int number) {
            return this.menuOptions.stream()
                    .filter(option -> option.getOptionNumber() == number)
                    .findFirst();
    }
}
