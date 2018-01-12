package com.twu.biblioteca.menu;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.helpers.CliHelper;

public class ListBooksOption extends MenuOption {

    public ListBooksOption(int optionNumber, Biblioteca biblioteca){
        super(optionNumber, "List of Books", biblioteca);
    }

    @Override
    public void view() {
        printAvailableBooksHeader();
        for (Book book : this.getBiblioteca().getBooks()){
            CliHelper.buildFormattedLine(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        }
    }

    private static void printAvailableBooksHeader() {
        CliHelper.print("These are the available books:\n");
        CliHelper.buildFormattedLine("Title", "Author", "Year");
    }


}
