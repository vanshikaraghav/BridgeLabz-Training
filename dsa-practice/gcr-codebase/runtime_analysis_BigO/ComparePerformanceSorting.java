package runtime_analysis_BigO;
import java.util.*;

public class ComparePerformanceSorting {

    static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j]>arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if(l<r) {
           int m = (l+r)/2;
           mergeSort(arr, l, m);
           mergeSort(arr, m+1, r);
           merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r-l+1];
        int i = l, j = m+1, k = 0;
        while(i<=m && j<=r) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while(i<=m) {
        	temp[k++] = arr[i++];
        }
        while(j<=r) {
        	temp[k++] = arr[j++];
        }
        for(i=l;i<=r;i++)
            arr[i] = temp[i - l];
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for(int j=low;j<high;j++) {
            if(arr[j]<pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i + 1];
        arr[i+1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new Random().ints(n, 1, 100000).toArray();
        int[] a1 = arr.clone();
        int[] a2 = arr.clone();
        int[] a3 = arr.clone();
        long start = System.currentTimeMillis();
        bubbleSort(a1);
        System.out.println("Bubble Sort: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        mergeSort(a2, 0, a2.length - 1);
        System.out.println("Merge Sort: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        quickSort(a3, 0, a3.length - 1);
        System.out.println("Quick Sort: " + (System.currentTimeMillis() - start) + " ms");
    }
}
