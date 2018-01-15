package com.twu.biblioteca.entities;

import java.util.ArrayList;
import java.util.List;

public class UserAccounts {

    private List<User> userAccounts;

    public UserAccounts(){
        this.userAccounts = new ArrayList<User>();
    }

    public List<User> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<User> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public void addUser(User user){
        this.userAccounts.add(user);
    }

    public User findUser(String libraryNumber) {

            return userAccounts.stream()
                    .filter(user -> user.getLibraryNumber().equals(libraryNumber))
                    .findFirst()
                    .get();


    }
}
