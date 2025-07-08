import java.util.*;
public class Gym {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> monsterFees = new LinkedHashMap<>();
        monsterFees.put("Ghoul",15000);
        monsterFees.put("Zombie",22000);
        monsterFees.put("Vampire",25000);
        monsterFees.put("Mummy",18000);
        int total =0;
        for(Map.Entry<String,Integer>e: monsterFees.entrySet()){
            String status = e.getValue()>20000 ?" VIP":"";
            System.out.println(e.getKey() +":"+e.getValue()+status);
            total = total + e.getValue();
        }
        System.out.println("Total collection: $"+total);
    }
}
