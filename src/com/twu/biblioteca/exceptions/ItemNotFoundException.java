package com.twu.biblioteca.exceptions;

public class ItemNotFoundException extends Throwable{

    public ItemNotFoundException(){
        super("Sorry, we could not find this item.");
    }
}
