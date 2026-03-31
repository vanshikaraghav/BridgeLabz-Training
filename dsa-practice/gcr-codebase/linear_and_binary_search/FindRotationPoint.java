package linear_and_binary_search;
import java.util.Scanner;

public class FindRotationPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter rotated sorted array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] > arr[right]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        System.out.println("Index of rotation point (smallest element): " + left);
        System.out.println("Rotation point value: " + arr[left]);
    }
}