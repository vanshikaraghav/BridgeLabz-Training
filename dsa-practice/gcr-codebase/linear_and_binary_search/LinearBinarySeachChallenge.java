package linear_and_binary_search;
import java.util.Arrays;

public class LinearBinarySeachChallenge {

    //Linear Search
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 1];
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0 && arr[i] <= n) {
                visited[arr[i]] = true;
            }
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }

    //Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] < target) {
            	left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive Integer: " + missing);
        Arrays.sort(arr);
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
