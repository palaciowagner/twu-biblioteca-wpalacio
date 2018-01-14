package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.Item;
import com.twu.biblioteca.entities.Movie;
import com.twu.biblioteca.helpers.CliHelper;

public class ListMoviesOption extends MenuOption {
    public ListMoviesOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "List Movies", biblioteca);
    }

    @Override
    public void view() {
        if (!(this.getBiblioteca().getItems().allAvailable(Movie.class).size() > 0)) {
            CliHelper.println("There are no movies available :(");
            CliHelper.println("Please, come later.");
            return;
        }
        showAvailableMoviesList();
    }

    private void showAvailableMoviesList() {
        printAvailableMoviesHeader();
        for (Item item : this.getBiblioteca().getItems().allAvailable(Movie.class)) {
            Movie movie = (Movie)item;
            CliHelper.buildFormattedLine(movie.getTitle(), movie.getDirector(), movie.getYear());
        }
        CliHelper.println("");
    }

    private static void printAvailableMoviesHeader() {
        CliHelper.print("\nThese are the available movies:\n\n");
        CliHelper.buildFormattedLine("Name", "Director", "Year");
    }
}
