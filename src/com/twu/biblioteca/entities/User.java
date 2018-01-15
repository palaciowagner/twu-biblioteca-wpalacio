package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.IncorrectPasswordException;

public class User {

    private String libraryNumber;
    private String password;
    private Profile userProfile;

    public User(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordCorrect(String password) throws IncorrectPasswordException{
        if (!this.password.equals(password)){
            throw new IncorrectPasswordException();
        }
        return true;
    }

    public Profile getProfile() {
        return userProfile;
    }

}
