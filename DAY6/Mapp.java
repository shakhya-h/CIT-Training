import java.util.*;
public class Mapp {
    public static void main(String[] args) {
        Map<String,Integer> marksMap = new HashMap<>();
        marksMap.put("Shakhya",100);
        marksMap.put("Shyam",68);
        marksMap.put("Ram",75);
        marksMap.put("Ratan",81);

        for(Map.Entry<String,Integer> entry :marksMap.entrySet()){
            System.out.println(entry.getKey()+" scored "+entry.getValue());
        }

        String topStudent = null;
        int highestMarks = Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> entry:marksMap.entrySet()){
            if(entry.getValue()>highestMarks){
                highestMarks = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        System.out.println("The top student is: "+topStudent+" with marks: "+highestMarks);
    }
}
