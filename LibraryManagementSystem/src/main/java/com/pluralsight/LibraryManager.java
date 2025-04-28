package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
//    Declaring array list to hold the objects
    private static ArrayList<Book> bookList;
    static Scanner scanner = new Scanner(System.in);
    static String title = "";
    static String author = "";
    static String serialNumber = "";
    static boolean availability = true;
    static String filename = "LibraryStore.txt";

//    Constructor for the Library
    public LibraryManager() {

        this.bookList = new ArrayList<>();
    }

//    outPut display method
    public static String display(String message){
        System.out.println(message);
        return message;
    }
//    Add books
     public void addBooks(){
        display("-------- Adding Books --------");
         display("Enter Book Title: ");
         title = scanner.nextLine().trim();
         display("Enter Book Author: ");
         author = scanner.nextLine().trim();
         display("Enter Book Serial Number: ");
         serialNumber = scanner.nextLine().trim();
         display("Enter Book Availability (e.g true/false): ");
         availability = scanner.nextBoolean();
         scanner.nextLine();

         Book book = new Book(title, author, serialNumber, availability);
         this.bookList.add(book);
         bookList.toString();
         writeInFile();
         display("Yeeee you've added the book Successfully");
     }

//     display all books
     public void displayBooks(){
      if (bookList.isEmpty()){
          display("Library is Empty bro");
          return;
      }
//      Calling books class to get the display function
      for (Book book: bookList){
          display(book.displayBookInfo());
          display("---- The End ----");
      }
     }

//     find books based on availability
    public void findBookBySN(){
        display("Enter SN: ");
        String SN = scanner.nextLine().trim();
        boolean found = false;
        for ( Book book : bookList){
         serialNumber = book.getSerialNumber();
          if (serialNumber.equalsIgnoreCase(SN)){
              String available = book.displayBookInfo();
              display("Available Book Based on Serial Number" +  "\n" + available);
              found = true;
              break;
          }
        }
        if (!found) {
            display("Invalid Entry");
        }
    }
//Availability
    public void availableBooks(){
        display("------------ Available Books ----------");
        for (Book book : bookList)
            if (book.isAvailability()){
                display(book.displayBookInfo());
            }
    }
    public void notAvailableBooks(){
        display("------------ Unavailable Books ----------");
        for (Book book : bookList)
            if (!book.isAvailability()){
                display(book.displayBookInfo());
            }
    }

//     Commented
     public void writeInFile(){

       try {
           FileWriter writer = new FileWriter(filename);
           String bookListToString = bookList.toString();
           writer.write(bookListToString);
           display("File Created Successfully");
           writer.close();
       } catch (IOException e) {
            e.printStackTrace();
       }
     }
//     public void readInFile(){
//        try {
//            BufferedReader bufReader = new BufferedReader(new FileReader(filename));
//            String line;
//            while ((line = bufReader.readLine()) != null){
//                String[] details = line.split(",");
//                String title = details[0];
//                String author = details[1];
//                String serialNumber = details[2];
//                boolean availability = Boolean.parseBoolean(details[3]);
//                Book newBook = new Book(title, author, serialNumber, availability);
//                bookList.add(newBook);
//            }
//            bufReader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//     }
}

