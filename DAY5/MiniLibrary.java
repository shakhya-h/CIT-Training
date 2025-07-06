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

    public String getTitle() {
        return title;
    }
}

class Book1 extends LibraryItem {
    private String author;

    public Book1(String title, int itemId, Double price, String author) {
        super(title, itemId, price);
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("Book");
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemId);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("---------------------------");
    }
}

class Magazine1 extends LibraryItem {
    private String issueMonth;

    public Magazine1(String title, int itemId, Double price, String issueMonth) {
        super(title, itemId, price);
        this.issueMonth = issueMonth;
    }

    public void displayDetails() {
        System.out.println("Magazine");
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemId);
        System.out.println("Issue Month: " + issueMonth);
        System.out.println("Price: ₹" + price);
        System.out.println("---------------------------");
    }
}

// Main class
public class MiniLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();
        int choice;

        do {
            // Menu Display
            System.out.println("\nMINI LIBRARY MENU:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display All Items");
            System.out.println("4. Search by Title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter Book Title: ");
                    String bTitle = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter Price: ");
                    Double bPrice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    items.add(new Book1(bTitle, bId, bPrice, author));
                    System.out.println("Book Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Magazine Title: ");
                    String mTitle = sc.nextLine();
                    System.out.print("Enter Magazine ID: ");
                    int mId = sc.nextInt();
                    System.out.print("Enter Price: ");
                    Double mPrice = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Issue Month: ");
                    String month = sc.nextLine();
                    items.add(new Magazine1(mTitle, mId, mPrice, month));
                    System.out.println("Magazine Added Successfully!");
                    break;

                case 3:

                    System.out.println("\nAll Library Items:");
                    if (items.isEmpty()) {
                        System.out.println("No items in the library.");
                    } else {
                        for (LibraryItem item : items) {
                            item.displayDetails();
                        }
                    }
                    break;

                case 4:

                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine().toLowerCase();
                    boolean found = false;
                    for (LibraryItem item : items) {
                        if (item.getTitle().toLowerCase().contains(searchTitle)) {
                            item.displayDetails();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No item found with that title.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

