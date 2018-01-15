package com.twu.biblioteca.entities;

import com.twu.biblioteca.exceptions.IncorrectPasswordException;

public class User {

    private String libraryNumber;
    private String password;
    private Profile userProfile;

    public User(String libraryNumber, String password, Profile profile){
        this.setLibraryNumber(libraryNumber);
        this.setPassword(password);
        this.setUserProfile(profile);
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

    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }
}
