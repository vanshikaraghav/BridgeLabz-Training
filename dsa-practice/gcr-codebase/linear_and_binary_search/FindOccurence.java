package linear_and_binary_search;
import java.util.Scanner;

public class FindOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }

    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                result = mid;
                right = mid - 1;
            }else if(arr[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                result = mid;
                left = mid + 1; 
            }else if(arr[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
