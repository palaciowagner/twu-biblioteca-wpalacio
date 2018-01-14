package com.twu.biblioteca;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.BibliotecaItems;
import com.twu.biblioteca.entities.Item;

import java.util.List;

public class BibliotecaTestBuilder {

    private BibliotecaItems items = new BibliotecaItems();

    public BibliotecaTestBuilder WithItems(List<Item> items){
        items.forEach(item -> this.items.add(item));
        return this;
    }

    public Biblioteca build(){
        Biblioteca biblioteca = new Biblioteca(items);
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
