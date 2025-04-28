package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static ArrayList<Book> bookList;
    static Scanner scanner = new Scanner(System.in);
    static String title = "";
    static String author = "";
    static String serialNumber = "";
    static boolean availability = true;

    public Manager() {
        this.bookList = new ArrayList<>();
    }
    public static String display(String message){
        System.out.println(message);
        return message;
    }
//    Adding books
    public void addBooks(){
        display("-------- Adding Books --------");
        display("Enter Book Title: ");
        title = scanner.nextLine().trim();
        display("Enter Book Author: ");
        author = scanner.nextLine().trim();
        display("Enter Book Serial Number: ");
        serialNumber = scanner.nextLine().trim();
        display("Enter Book Availability: ");
        availability = scanner.nextBoolean();
        scanner.nextLine();

        Book book = new Book(title, author, serialNumber, availability);
        this.bookList.add(book);
        bookList.toString();
//        writeInFile();
        display("Yeeee you've added the book Successfully");
    }

//    display all books
public void displayBooks(){
    if (bookList.isEmpty()){
        display("Library is Empty bro");
        return;
    }
//      Calling books class to get the display function
    for (Book book: bookList){
        display(book.displayBookInfo()); // Call without arguments and display the returned String
//          display("---- The End ----");
    }
}
}
