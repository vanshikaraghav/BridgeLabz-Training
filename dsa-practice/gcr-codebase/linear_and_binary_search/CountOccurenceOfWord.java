package linear_and_binary_search;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountOccurenceOfWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();
        System.out.print("Enter word to search: ");
        String targetWord = sc.nextLine();
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String word : words) {
                    if(word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("Word '" + targetWord + "' occurred " + count + " times.");
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
