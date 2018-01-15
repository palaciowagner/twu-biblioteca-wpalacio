package com.twu.biblioteca.entities;

public class UserTestBuilder {

    private String libraryNumber = "1234-5678";
    private String password = "test";
    private Profile profile = new Profile("Wagner", "wpalacio@tw.com", "9323-8233");

    public UserTestBuilder WithLibraryNumber(String libraryNumber){
        this.libraryNumber = libraryNumber;
        return this;
    }

    public User build(){
        return new User(libraryNumber, password, profile);
    }


}
