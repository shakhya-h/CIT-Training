import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected Double price;

    public LibraryItem(String title, int itemId, Double price) {
        this.title = title;
        this.itemId = itemId;
        this.price = price;
    }

    public abstract void displayDetails();

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    private String author;
    private boolean isIssued = false;

    public Book(String title, int itemId, Double price, String author) {
        super(title, itemId, price);
        this.author = author;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void displayDetails() {
        System.out.println("Book");
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemId);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Issued: " + (isIssued ? "Yes" : "No"));
        System.out.println("");
    }
}

public class Library1 {
    public static void main(String[] args) {
        ArrayList<LibraryItem> allItems = new ArrayList<>();
        ArrayList<Book2> issuedBooks = new ArrayList<>();
        ArrayList<Book2> returnedBooks = new ArrayList<>();

        Book2 b1 = new Book2("The Alchemist", 101, 299.99, "Paulo Coelho");
        Book2 b2 = new Book2("Wings of Fire", 102, 350.0, "A.P.J Abdul Kalam");
        Book2 b3 = new Book2("National Geographic", 201, 120.0, "July");
        Book2 b4 = new Book2("Forbes India", 202, 150.0, "August");

        allItems.add(b1);
        allItems.add(b2);
        allItems.add(b3);
        allItems.add(b4);

        b1.issueBook();
        issuedBooks.add(b1);

        b2.issueBook();
        b2.returnBook();
        returnedBooks.add(b2);

        System.out.println("\nAll Library Items:");
        System.out.println("");
        for (LibraryItem item : allItems) {
            item.displayDetails();
        }

        System.out.println("=========================");
        System.out.println("\nIssued Books:");
        for (Book2 book : issuedBooks) {
            book.displayDetails();
        }

        System.out.println("\nReturned Books:");
        for (Book2 book : returnedBooks) {
            book.displayDetails();
        }
    }
}
