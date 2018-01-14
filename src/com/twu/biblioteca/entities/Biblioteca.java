package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.ItemNotFoundException;

import java.util.List;

public class Biblioteca {

    private BibliotecaItems items;

    public Biblioteca(BibliotecaItems items){
        this.setItems(items);
    }

    public String checkout(String title) {
        try {
            Item item = this.items.find(title);
            return item.checkout(item);
        } catch (ItemNotFoundException e) {
            return "Sorry, we could not find this item.";
        }
    }

    public String returnItem(String title) {
        try {
            Item item = this.items.find(title);
            return item.returnItem(item);
        } catch (ItemNotFoundException e) {
            return "Sorry, we could not find this item.";
        }
    }

    public BibliotecaItems getItems(){
        return items;
    }

    public List<Item> getAllItems(){
        return items.all();
    }

    public void setItems(BibliotecaItems items) {
        this.items = items;
    }
}
