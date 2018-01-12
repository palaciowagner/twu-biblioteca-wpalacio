package com.twu.biblioteca.Menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuOption> menuOptions;

    public Menu(){
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, "List of Books"));
        }};

    }
    public String options() {
        StringBuilder options =  new StringBuilder();
        this.menuOptions.forEach(option -> options.append(option.show()));
        return options.toString();
    }
}
