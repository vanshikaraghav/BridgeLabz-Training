package linear_and_binary_search;
import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n - 1;
        int peakIndex = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            boolean leftOk = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == n - 1 || arr[mid] > arr[mid + 1]);
            if(leftOk && rightOk) {
                peakIndex = mid;
                break;
            }else if(mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println("Index of peak element: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}