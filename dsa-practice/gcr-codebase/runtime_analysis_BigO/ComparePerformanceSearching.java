package runtime_analysis_BigO;
import java.util.*;

public class ComparePerformanceSearching {

    // Linear Search
    static int linearSearch(int[] arr, int target) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==target)
                return i;
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low<=high) {
            int mid = (low+high) / 2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = i;
        }
        int target = n - 1;
        long start = System.currentTimeMillis();
        linearSearch(arr, target);
        long end = System.currentTimeMillis();
        System.out.println("Linear Search Time: "+(end-start)+" ms");
        start = System.currentTimeMillis();
        binarySearch(arr, target);
        end = System.currentTimeMillis();
        System.out.println("Binary Search Time: "+(end-start)+" ms");
    }
}
