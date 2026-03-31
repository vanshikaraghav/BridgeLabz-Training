package stack_queue_hashmap;
import java.util.*;

public class LongestConsecutiveSequence {
	
	public static int longestSequence(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, true);
        }
        int maxLength = 0;
        for(int num : arr) {
            if(!map.containsKey(num - 1)) {
                int currentNum = num;
                int length = 1;
                while(map.containsKey(currentNum + 1)) {
                    currentNum++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestSequence(arr));
    }
}
