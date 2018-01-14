package com.twu.biblioteca;

public class Book extends Item {

    private String title;
    private String author;
    private String publishedYear;
    private boolean isAvailable;

    public Book(String title, String author, String publishedYear, boolean isAvailable){
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublishedYear(publishedYear);
        this.setIsAvailable(isAvailable);
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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

    @Override
    public String checkout(Item item) {
        Book book = (Book)item;
        String returnMessage = "That book is not available!";
        if (book.isAvailable()) {
            book.setIsAvailable(false);
            return "Thank you! Enjoy the book!";
        }
        return returnMessage;
    }

    @Override
    public String returnItem(Item item) {
        Book book = (Book)item;
        String returnMessage = "That is not a valid book to return.";
        if (!book.isAvailable()) {
            book.setIsAvailable(true);
            return "Thank you for returning the book!";
        }
        return returnMessage;
    }
}
