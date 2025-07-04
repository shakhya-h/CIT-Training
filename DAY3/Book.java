public class Book {

    private String title;
    private String author;

    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("--------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {

        Book book1 = new Book();
        book1.display();

        Book book2 = new Book("Wings of Fire", "Dr. A.P.J. Abdul Kalam");
        book2.display();

    }
}