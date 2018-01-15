package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.BibliotecaTestBuilder;

import java.util.ArrayList;
import java.util.List;

public class MenuTestBuilder {

    private List<MenuOption> menuOptions;
    private Biblioteca biblioteca;

    public MenuTestBuilder WithOptions(List<MenuOption> menuOptions){
        this.menuOptions = menuOptions;
        return this;
    }

    public MenuTestBuilder WithBiblioteca(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        return this;
    }

    public Menu build(){
        this.biblioteca = new BibliotecaTestBuilder().build();
        this.menuOptions = new ArrayList<MenuOption>(){{
            add(new ListBooksOption(1, biblioteca));
            add(new CheckoutBookOption(2, biblioteca));
            add(new ReturnBookOption(3, biblioteca));
            add(new QuitOption(4, biblioteca));
        }};
        return new Menu(this.biblioteca);
    }
}