package map_interface;
import java.util.*;

public class KeyWithHighestValues {
	static String maxValueKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
	
	public static void main(String[] args) {
		Map<String, Integer> values = new HashMap<>();
        values.put("A", 10);
        values.put("B", 20);
        values.put("C", 15);
        System.out.println("Key with Max Value: " + maxValueKey(values));
	}
}
