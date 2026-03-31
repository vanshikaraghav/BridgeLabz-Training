package map_interface;
import java.util.*;

public class WordFrequencyCounter {
	
	static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
	
	public static void main(String[] args) {
		String text = "Hello world, hello Java!";
        System.out.println("Word Frequency: " + wordFrequency(text));
	}
}
