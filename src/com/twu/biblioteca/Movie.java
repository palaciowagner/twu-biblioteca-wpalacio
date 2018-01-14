package com.twu.biblioteca;

public class Movie extends Item {
    private String year;
    private String director;
    private int rating;
    private boolean isAvailable;

    public Movie(String name, String year, String director, int rating, boolean isAvailable){
        this.setTitle(name);
        this.setYear(year);
        this.setDirector(director);
        this.setRating(rating);
        this.setIsAvailable(isAvailable);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String checkout(Item item) {
        return null;
    }

    @Override
    public String returnItem(Item item) {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
