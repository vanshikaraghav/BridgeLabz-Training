package runtime_analysis_BigO;
import java.util.*;

public class CompareDataStructure {

    // Linear search in array
    static boolean arraySearch(int[] arr, int target) {
        for(int x : arr) {
            if(x == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int target = n - 1;
        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<n;i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        long start = System.currentTimeMillis();
        arraySearch(array, target);
        System.out.println("Array Search Time: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
