package com.twu.biblioteca.entities;

public class User {

    private String libraryNumber;
    private String password;

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

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }
}
