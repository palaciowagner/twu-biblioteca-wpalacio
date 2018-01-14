package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BibliotecaItems {

    private List<Item> items;

    public BibliotecaItems(){
        this.items = new ArrayList<Item>();
    }

    public List<Item> all(){
        return this.items;
    }

    public List<Item> add(Item item){
        this.items.add(item);
        return this.items;
    }

    public Item find(String title) throws ItemNotFoundException {
        try {
            return items
                    .stream()
                    .filter(item -> item.getTitle()
                            .equals(title))
                    .findFirst()
                    .get();

        }
        catch (NoSuchElementException ex){
            throw new ItemNotFoundException();
        }
    }

    public List<Item> allAvailable(Class<?> item){
        return items
                .stream()
                .filter(product-> product.getClass()
                        .equals(item) && product.isAvailable())
                .collect(Collectors.toList());
    }

}
