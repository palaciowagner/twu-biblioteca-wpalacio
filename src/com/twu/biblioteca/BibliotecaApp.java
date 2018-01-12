package com.twu.biblioteca;

import com.twu.biblioteca.helpers.CliHelper;

import java.util.ArrayList;

public class BibliotecaApp {


    public static void main(String[] args) {
        Biblioteca biblioteca =  createBiblioteca();
        showWelcomeMessage();
        listBooks(biblioteca);
    }

    private static void listBooks(Biblioteca biblioteca) {
        printAvailableBooksHeader();
        for (Book book : biblioteca.getBooks()){
            CliHelper.buildFormattedLine(book.getTitle(), book.getAuthor(), book.getPublishedYear());
        }
    }

    private static void printAvailableBooksHeader() {
        System.out.println("These are the available books:");
        CliHelper.buildFormattedLine("Title", "Author", "Year");
    }

    private static void showWelcomeMessage() {
        System.out.println("===== Welcome to TWU Biblioteca =====");
    }

    private static Biblioteca createBiblioteca() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book harry_potter = new Book("Harry Potter", "J.K. Rowling", "1997");
        Book lord_of_the_rings = new Book("Lord of the rings", "J.R.R. Tolkien", "1980");
        books.add(harry_potter);
        books.add(lord_of_the_rings);
        return new Biblioteca(books);
    }


}
