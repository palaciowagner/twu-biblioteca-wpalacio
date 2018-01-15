package com.twu.biblioteca.entities;

public class Profile {
    private String name;
    private String email;
    private String phone;

    public Profile(String name, String email, String phone){
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
