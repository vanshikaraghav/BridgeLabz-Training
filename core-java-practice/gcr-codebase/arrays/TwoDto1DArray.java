package arrays;
import java.util.Scanner;

public class TwoDto1DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] array = new int[rows*columns];
        int index = 0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns;j++) {
                array[index++] = matrix[i][j];
            }
        }
        System.out.println("1D Array: ");
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
	}

}
