import java.util.*;
public class City {
    String name;
    int literacyrate, population, noec;

    City(String name,int literacyrate,int population,int noec) {
        this.name = name;
        this.literacyrate= literacyrate;
        this.population = population;
        this.noec = noec;
    }

    public double calculateScore() {
        return (literacyrate + population + noec)/1000000;
    }

    public void displayCity() {
        System.out.println("City: " + name);
        System.out.println("Literacy Rate: " + literacyrate + "%");
        System.out.println("Population: " + population);
        System.out.println("Engineering Colleges: " + noec);
        System.out.printf("Score: %.2f" , calculateScore());
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        List<City> sheher = new ArrayList<>();
        sheher.add(new City("Kolkata", 90, 25000000, 150));
        sheher.add(new City("Patna", 78, 6500000, 90));
        sheher.add(new City("Raipur", 85, 12500000, 110));
        sheher.add(new City("Jamshedpur", 88, 7000000, 80));
        sheher.add(new City("Bhilai", 84, 8000000, 75));
        sheher.add(new City("Bhuvaneshwar", 89, 8500000, 95));
        sheher.add(new City("Pune", 92, 9000000, 140));
        sheher.add(new City("Tirupur", 80, 5000000, 60));
        sheher.add(new City("Kochin", 93, 12000000, 100));
        sheher.add(new City("Hazaribagh", 79, 3000000, 40));


    //   Collections.sort(sheher, new Comparator<City>() {
    //         public int compare(City c1, City c2) {
    //             return Double.compare(c2.calculateScore(), c1.calculateScore());
    //         }
    //     });

        Collections.sort(sheher,(s1,s2) -> Double.compare(s2.calculateScore(),s1.calculateScore()));
        

        System.out.println("Top 2 Cities Based on All 3 Criteria:\n");
        for (int i = 0; i < 2; i++) {
            sheher.get(i).displayCity();
        }
    }
    
}
