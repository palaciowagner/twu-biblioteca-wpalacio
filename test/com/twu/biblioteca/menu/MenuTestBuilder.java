package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.BibliotecaTestBuilder;

import java.util.ArrayList;
import java.util.List;

public class MenuTestBuilder {

    private List<MenuOption> menuOptions;
    private Biblioteca biblioteca;

    public MenuTestBuilder WithOptions(List<MenuOption> menuOptions){
        this.menuOptions = menuOptions;
        return this;
    }

    public Menu build(){
        this.biblioteca = new BibliotecaTestBuilder().build();
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, biblioteca));
            add(new QuitOption(2, biblioteca));
        }};
        return new Menu(this.biblioteca);
    }
}