
import java.util.*;

class InvalidAdopterException extends Exception {

    public InvalidAdopterException(String msg) {
        super(msg);
    }
}

public class WildlifeAdoptionTracker1 {

    public static void main(String[] args) throws InvalidAdopterException {
        TreeMap<Integer, String> adoptionMap = new TreeMap<>();
        int total = 0;
        try {
            addAdoption(adoptionMap, 1, "Shakhya");
            addAdoption(adoptionMap, 2, "Samanta");
            addAdoption(adoptionMap, 3, "Rushat");
            addAdoption(adoptionMap, 5, "Jay");
            addAdoption(adoptionMap, 4, "Yuvraj");
            //addAdoption(adoptionMap, 8, "");

            for (Map.Entry<Integer, String> entry : adoptionMap.entrySet()) {
                System.out.println("Animal ID: " + entry.getKey() + "  Adopter: " + entry.getValue());
                total +=1;
            }
            System.out.println("Total adoption : " + total);
        }
        catch(InvalidAdopterException e)
        {
        System.out.println("Invalid Adopter Exception: " + e.getMessage());
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



