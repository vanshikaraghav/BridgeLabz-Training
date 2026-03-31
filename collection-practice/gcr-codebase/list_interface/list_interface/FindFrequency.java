package list_interface;
import java.util.*;

public class FindFrequency {
	
	public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
	
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Frequency: " + findFrequency(fruits));
	}
}
