package com.twu.biblioteca;

public abstract class Item {
    private String title;

    public abstract String checkout(Item item);
    public abstract String returnItem(Item item);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract boolean isAvailable();
}
