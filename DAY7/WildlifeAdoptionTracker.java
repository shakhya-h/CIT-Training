import java.util.*;

class InvalidAdopterException extends Exception {
    public InvalidAdopterException(String message) {
        super(message);
    }
}

public class WildlifeAdoptionTracker {
    public static void main(String[] args) {
        TreeMap<Integer, String> adoptionMap = new TreeMap<>();

        try {
            addAdoption(adoptionMap, 101, "Rahul");
            addAdoption(adoptionMap, 102, "Shakhya");
            addAdoption(adoptionMap, 103, "Ratan");
           // addAdoption(adoptionMap, 104, "");
            addAdoption(adoptionMap, 105, "Ramlala");

            System.out.println("Wildlife Adoption List (Sorted by Animal ID):");
            for (Map.Entry<Integer, String> entry : adoptionMap.entrySet()) {
                System.out.println("Animal ID: " + entry.getKey() + " → Adopter: " + entry.getValue());
            }

        } catch (InvalidAdopterException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addAdoption(TreeMap<Integer, String> map, int animalID, String adopterName)
            throws InvalidAdopterException {
        if (adopterName == null || adopterName.trim().isEmpty()) {
            throw new InvalidAdopterException("Adopter name cannot be null or blank for Animal ID: " + animalID);
        }
        map.put(animalID, adopterName);
    }
}