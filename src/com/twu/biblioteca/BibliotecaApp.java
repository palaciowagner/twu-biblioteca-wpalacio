package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static final String DASH_TOPIC = " - ";

    public static void main(String[] args) {


        Biblioteca biblioteca =  startBiblioteca();
        showWelcomeMessage();
        listBooks(biblioteca);
    }

    private static void listBooks(Biblioteca biblioteca) {
        System.out.println("These are the available books:");
        for (Book book : biblioteca.getBooks()){
            System.out.println(DASH_TOPIC + book.getTitle());
        }
    }

    private static void showWelcomeMessage() {
        System.out.println("===== Welcome to TWU Biblioteca =====");
    }

    private static Biblioteca startBiblioteca() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book harry_potter = new Book("Harry Potter");
        Book lord_of_the_rings = new Book("Lord of the rings");
        books.add(harry_potter);
        books.add(lord_of_the_rings);
        return new Biblioteca(books);
    }


}
