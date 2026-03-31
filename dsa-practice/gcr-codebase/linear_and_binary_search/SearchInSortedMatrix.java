package linear_and_binary_search;
import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements row by row:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();
        int left = 0;
        int right = rows * cols - 1;
        boolean found = false;
        while(left <= right) {
            int mid = (left + right) / 2;
            int midRow = mid / cols;
            int midCol = mid % cols;
            int midValue = matrix[midRow][midCol];
            if(midValue == target) {
                found = true;
                break;
            }else if(midValue < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println("Target found: " + found);
    }
}