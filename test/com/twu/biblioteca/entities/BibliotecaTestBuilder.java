package com.twu.biblioteca.entities;

import java.util.List;

public class BibliotecaTestBuilder {

    private BibliotecaItems items = new BibliotecaItems();
    private UserAccounts userAccounts = new UserAccounts();

    public BibliotecaTestBuilder WithItems(List<Item> items){
        items.forEach(item -> this.items.add(item));
        return this;
    }

    public BibliotecaTestBuilder WithUserAccounts(List<User> users){
        userAccounts.setUserAccounts(users);
        return this;
    }

    public Biblioteca build(){
        this.userAccounts.addUser(new UserTestBuilder().build());

        Biblioteca biblioteca = new Biblioteca(items, userAccounts);
        this.items.add(new BookTestBuilder().build());
        this.items.add(new BookTestBuilder().WithTitle("Lord of the rings")
                                            .WithAuthor("J.R.R. Tolkien")
                                            .WithPublishedYear("1980").build());
        this.items.add(new BookTestBuilder().WithTitle("O Alquimista")
                                            .WithAuthor("Paulo Coelho")
                                            .WithPublishedYear("1990")
                                            .WithIsAvailable(false).build());
        this.items.add(new MovieTestBuilder().build());


        return biblioteca;
    }
}
