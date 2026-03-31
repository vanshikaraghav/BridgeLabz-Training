package list_interface;
import java.util.*;

public class RemoveDuplicates {
	public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int num : list) {
            if(!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		List<Integer> duplicates = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("After Removing Duplicates: " + removeDuplicates(duplicates));
	}
}
