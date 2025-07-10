import java.io.*;
import java.util.*;

public class LogCleaner {
    public static void main(String[] args) {
        String inputFile = "log.txt";
        String outputFile = "clean_log.txt";


        Set<String> uniqueLines = new LinkedHashSet<>();

    
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                uniqueLines.add(line); 
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String uniqueLine : uniqueLines) {
                bw.write(uniqueLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }

        System.out.println("Duplicates removed and written to " + outputFile);
    }
}

