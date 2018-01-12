package com.twu.biblioteca;

public class Book {

    private String title;
    private String author;
    private String publishedYear;
    private boolean isAvailable;

    public Book(String title, String author, String publishedYear, boolean isAvailable){
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublishedYear(publishedYear);
        this.setAvailable(isAvailable);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }
}
