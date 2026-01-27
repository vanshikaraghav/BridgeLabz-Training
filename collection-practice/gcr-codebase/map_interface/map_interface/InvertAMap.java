package map_interface;
import java.util.*;

public class InvertAMap {
	
	static <K, V> Map<V, List<K>> invertMap(Map<K, V> input) {
        Map<V, List<K>> result = new HashMap<>();
        for(Map.Entry<K, V> entry : input.entrySet()) {
            result
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }
        return result;
    }
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        System.out.println("Inverted Map: " + invertMap(map));
	}
}
