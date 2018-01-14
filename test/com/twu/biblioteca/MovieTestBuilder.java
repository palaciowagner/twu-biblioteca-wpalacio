package com.twu.biblioteca;

public class MovieTestBuilder {

    private String name = "Star Wars";
    private String year = "1980";
    private String director = "George Lucas";
    private int rating = 8;
    private boolean isAvailable = true;

    public MovieTestBuilder WithName(String name){
        this.name = name;
        return this;
    }


    public MovieTestBuilder WithYear(String year){
        this.year = year;
        return this;
    }


    public MovieTestBuilder WithDirector(String director){
        this.director = director;
        return this;
    }


    public MovieTestBuilder WithRating(int rating){
        this.rating = rating;
        return this;
    }

    public Movie build(){
        return new Movie(name, year, director, rating, isAvailable);
    }
}
