package stack_queue_hashmap;
import java.util.*;

public class PairWithSum {
	public static boolean hasPair(int[] arr, int target) {
		
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : arr) {
            if(map.containsKey(target - num)) {
                return true;
            }
            map.put(num, true);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        System.out.println(hasPair(arr, target));
    }
}
