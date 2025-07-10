import java.io.*;
import java.util.*;

public class AdvancedLogCleaner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputPath = sc.nextLine();

        System.out.print("Enter output file path: ");
        String outputPath = sc.nextLine();

        List<String> lines = readLines(inputPath);

        if (lines == null) {
            System.out.println("Could not read input file.");
            return;
        }

        while (true) {
            System.out.println("\n=== Log Cleaning Menu ===");
            System.out.println("1. Remove Duplicate Lines");
            System.out.println("2. Remove Duplicate Words (per line)");
            System.out.println("3. Remove a Particular Line");
            System.out.println("4. Remove Last 2 Lines");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    lines = removeDuplicateLines(lines);
                    System.out.println("Duplicate lines removed.");
                    break;
                case 2:
                    lines = removeDuplicateWords(lines);
                    System.out.println("Duplicate words removed in each line.");
                    break;
                case 3:
                    System.out.print("Enter the exact line to remove: ");
                    String toRemove = sc.nextLine();
                    lines = removeParticularLine(lines, toRemove);
                    System.out.println("Specified line removed if it existed.");
                    break;
                case 4:
                    lines = removeLastNLines(lines, 2);
                    System.out.println("Last 2 lines removed.");
                    break;
                case 5:
                    writeLines(outputPath, lines);
                    System.out.println("File saved at: " + outputPath);
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static List<String> readLines(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                lines.add(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return lines;
    }

    public static void writeLines(String path, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static List<String> removeDuplicateLines(List<String> lines) {
        return new ArrayList<>(new LinkedHashSet<>(lines));
    }

    public static List<String> removeDuplicateWords(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            Set<String> wordSet = new LinkedHashSet<>(Arrays.asList(line.split("\\s+")));
            result.add(String.join(" ", wordSet));
        }
        return result;
    }

    public static List<String> removeParticularLine(List<String> lines, String targetLine) {
        List<String> updated = new ArrayList<>();
        for (String line : lines) {
            if (!line.equals(targetLine))
                updated.add(line);
        }
        return updated;
    }

    public static List<String> removeLastNLines(List<String> lines, int n) {
        int size = lines.size();
        if (size <= n)
            return new ArrayList<>();
        return new ArrayList<>(lines.subList(0, size - n));
    }
}