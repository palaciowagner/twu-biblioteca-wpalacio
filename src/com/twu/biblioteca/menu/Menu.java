package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.helpers.CliHelper;
import com.twu.biblioteca.exceptions.InvalidOptionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Menu {

    private List<MenuOption> menuOptions;
    private boolean isMenuActive;

    public Menu(Biblioteca biblioteca){
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, biblioteca));
            add(new CheckoutBookOption(2, biblioteca));
            add(new ReturnBookOption(3, biblioteca));
            add(new QuitOption(4, biblioteca));

        }};
        setIsMenuActive(true);
    }

    public void printOptions(){
        CliHelper.print(showOptions());
    }

    public String showOptions() {
        CliHelper.print("\nMenu:\n");
        StringBuilder options =  new StringBuilder();
        this.menuOptions.forEach(option -> options.append(option.print() + "\n"));
        return options.toString();
    }

    public void getUserOption(){
        while(isMenuActive) {
            chooseOption(getUserOption("Please, select an option: "));
        }
    }

    private void chooseOption(int number){

        try{
            MenuOption option = findOption(number);
            setIsMenuActive(!option.isQuitApp());
            option.view();
        }
        catch (InvalidOptionException ex){
            int newNumber = getUserOption(ex.getMessage());
            chooseOption(newNumber);
        }
    }

    private int getUserOption(String message) {
        return parseInt(CliHelper.getUserInput(message));
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

    private void setIsMenuActive(boolean quitApp) {
        this.isMenuActive = quitApp;
    }

}
