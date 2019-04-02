package Programm;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int publishedAmount;
    private GregorianCalendar publicationDate;
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
    public Book() {

    }

    public Book(String name, int publishedAmount, double price, Author author, GregorianCalendar publicationDate) {
        this.name = name;
        this.publishedAmount = publishedAmount;
        this.price = price;
        this.author = author;
        //this.publicationDate = sdf.format(publicationDate.getTime());
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public int getPublishedAmount() {
        return publishedAmount;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    public GregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(GregorianCalendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPublishedAmount(int publishedAmount) {
        this.publishedAmount = publishedAmount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", publishedAmount=" + publishedAmount +
                ", publicationDate=" + publicationDate.getTime() +
                '}';
    }
}
