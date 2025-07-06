import java.util.*;

abstract class LibrtaryItem{
    protected int id;
    protected String title;
    protected String author;

    public LibrtaryItem(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void displayDetails(){
        System.out.println("ID: " + id+" Title: "+title+" Author: "+author);
    }
}
class Book extends LibrtaryItem{
    private boolean isIssued;
    public Book(int id,String title,String author){
        super(id,title,author);
    }

    public void issueBook(){
        isIssued = true;
    }

    public void returnBook(){
        isIssued = false;
    }

    public boolean isIssued(){
        return isIssued();
    }
}

class Magazine extends LibrtaryItem{
    Magazine(int id,String title,String author){
        super(id,title,author);
    }
}

public class Library {
    public static void main(String[] args) {
        Book1 b = new Book1(1,"The Mountains Echoed","Khaled Hosseini");
        Magazine1 m = new Magazine1(2,"A Thousand Splendid Suns","Khaled Hosseini");
        List<LibrtaryItem> l= new ArrayList<>();
        ArrayList<Book1> issuedBooks = new ArrayList<>();
        ArrayList<Book1> returnedBooks = new ArrayList<>();
        l.add(b);
        l.add(m);
        Book1 b1 = (new Book1(3, "Swami and Friends", "RK Naryan"));
        Book1 b2 = (new Book1(4, "Malgudi Days", "RK Naryan"));
        Book1 b3 = (new Book1(5, "The Blue Umbrella", "Ruskin Bond"));
        l.add(b1);
        l.add(b2);
        l.add(b3);
        System.out.println("All Items: ");
        for(int i=0;i<l.size();i++){
            l.get(i).displayDetails();
        }
        b1.issueBook();
        issuedBooks.add(b1);

        b2.returnBook();
        returnedBooks.add(b2);

        System.out.println("Returned books: ");
        for(int i=0;i<returnedBooks.size();i++){
            returnedBooks.get(i).displayDetails();
        }
        
        System.out.println("Issued books: ");
        for(int i=0;i<issuedBooks.size();i++){
            issuedBooks.get(i).displayDetails();
        }


    }
    
}
