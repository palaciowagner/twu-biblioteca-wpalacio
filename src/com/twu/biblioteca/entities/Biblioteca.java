package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.IncorrectPasswordException;
import com.twu.biblioteca.exceptions.ItemNotFoundException;
import com.twu.biblioteca.exceptions.UserNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

public class Biblioteca {

    private BibliotecaItems items;
    private UserAccounts userAccounts;
    private User loggedInUser;

    public Biblioteca(BibliotecaItems items, UserAccounts userAccounts) {
        this.setItems(items);
        this.setUserAccounts(userAccounts);
    }

    public String checkout(String title) {
        try {
            Item item = this.items.find(title);
            return item.checkout(item);
        } catch (ItemNotFoundException e) {
            return e.getMessage();
        }
    }

    public String returnItem(String title) {
        try {
            Item item = this.items.find(title);
            return item.returnItem(item);
        } catch (ItemNotFoundException e) {
            return e.getMessage();
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

    public boolean signIn(String libraryNumber, String password) throws UserNotFoundException, IncorrectPasswordException{
        try{
            User user = this.userAccounts.findUser(libraryNumber);
            this.setLoggedInUser(user);
            return user.isPasswordCorrect(password);
        }
        catch (NoSuchElementException ex){
            throw new UserNotFoundException();
        }
        catch (IncorrectPasswordException ex){
            throw ex;
        }
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
