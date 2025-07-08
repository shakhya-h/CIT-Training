import java.util.*;

class FirstUnique {
    private LinkedHashMap<Character, Integer> map;

    public FirstUnique() {
        map = new LinkedHashMap<>();
    }

    public void add(char letter) {
        map.put(letter, map.getOrDefault(letter, 0) + 1);
    }

    public char showFirstUnique() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}

public class FirstUniqueMain {
    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique();

        firstUnique.add('a');
        firstUnique.add('b');
        firstUnique.add('c');
        System.out.println(firstUnique.showFirstUnique());

        firstUnique.add('a');
        System.out.println(firstUnique.showFirstUnique());

        firstUnique.add('b');
        firstUnique.add('c');
        System.out.println(firstUnique.showFirstUnique());
    }
}