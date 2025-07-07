import java.util.*;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

public class AlienShop {
    public static void main(String[] args) {
        HashMap<Integer, Double> alienPurchases = new HashMap<>();

        try {

            addAlien(alienPurchases, 101, 1250.50);
            addAlien(alienPurchases, 102, 980.0);
            addAlien(alienPurchases, 103, 1875.75);
            addAlien(alienPurchases, 104, 560.0);

            double maxAmount = Collections.max(alienPurchases.values());
            System.out.println("Maximum Purchase: " + maxAmount);
            System.out.print("Aliens who spent the most: ");
            for (Map.Entry<Integer, Double> entry : alienPurchases.entrySet()) {
                if (entry.getValue().equals(maxAmount)) {
                    System.out.print("Alien ID: " + entry.getKey());
                }
            }

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addAlien(HashMap<Integer, Double> map, int id, double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Purchase amount cannot be negative for Alien ID: " + id);
        }
        map.put(id, amount);
    }
}
