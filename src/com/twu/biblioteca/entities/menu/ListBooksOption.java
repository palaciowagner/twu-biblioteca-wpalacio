package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.Book;
import com.twu.biblioteca.entities.Item;
import com.twu.biblioteca.helpers.CliHelper;

public class ListBooksOption extends MenuOption {

    public ListBooksOption(int optionNumber, Biblioteca biblioteca){
        super(optionNumber, "List of Books", biblioteca);
    }

    @Override
    public void view() {
        if (!(this.getBiblioteca().getItems().allAvailable(Book.class).size() > 0)) {
            CliHelper.println("There are no books available :(");
            CliHelper.println("Please, come later.");
            return;
        }
        showAvailableBooksList();
    }

    private void showAvailableBooksList() {
        printAvailableBooksHeader();
        for (Item item : this.getBiblioteca().getItems().allAvailable(Book.class)) {
            Book book = (Book)item;
            CliHelper.buildFormattedLine(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        }
        CliHelper.println("");
    }

    private static void printAvailableBooksHeader() {
        CliHelper.print("\nThese are the available books:\n\n");
        CliHelper.buildFormattedLine("Title", "Author", "Year");
    }
}
