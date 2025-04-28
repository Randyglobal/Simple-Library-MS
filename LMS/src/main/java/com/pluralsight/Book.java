package com.pluralsight;

public class Book {
    private String title = "";
    private String author = "";
    private String serialNumber = "";
    private boolean availability = true;

    public Book(String title, String author, String serialNumber, boolean availability) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.availability = availability;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public String displayBookInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("-----Book Details-------\n"); // Added a newline for better formatting
        sb.append("Book Title: ").append(this.title).append("\n"); // Use this.title
        sb.append("Book Author: ").append(this.author).append("\n"); // Use this.author
        sb.append("Serial Number: ").append(this.serialNumber).append("\n"); // Use this.serialNumber
        sb.append("Availability: ").append(this.availability); // Use this.availability
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", availability=" + availability +
                '}';
    }
}
