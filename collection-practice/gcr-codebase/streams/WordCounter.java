package streams; 
import java.io.*;
import java.util.*;

public class WordCounter {
    private static final String name = "sample_text.txt";
    public static void main(String[] args) { 
        createDummyTextFile(name);
        Map<String, Integer> wordFrequencies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String line;
            while((line = reader.readLine()) != null) { 
                String[] words = line.toLowerCase().split("\\W+");
                for(String word : words) {
                    if(!word.trim().isEmpty()) {  
                        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }catch(IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        int totalWords = wordFrequencies.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words in the file: " + totalWords);
        System.out.println("\nTop 5 most frequently occurring words:");
        wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void createDummyTextFile(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            System.out.println("Dummy text file already exists: " + filePath);
            return;
        }
        System.out.println("Creating dummy text file: " + filePath + "...");
        try(FileWriter writer = new FileWriter(filePath)) {
            writer.write("Java is a programming language. Java is widely used. " +
                         "Java is popular. Programming is fun. Language is key.");
        }catch(IOException e) {
            System.err.println("Error creating dummy text file: " + e.getMessage());
        }
    }
}