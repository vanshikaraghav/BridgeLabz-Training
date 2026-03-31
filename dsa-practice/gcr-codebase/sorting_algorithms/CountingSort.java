package sorting_algorithms;
import java.util.Scanner;

public class CountingSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the ages (between 10 and 18):");
        for(int i=0;i<n;i++) {
            ages[i] = sc.nextInt();
        }
        int range = 9;
        int[] count = new int[range + 1];
        int[] output = new int[n];
        for(int i=0;i<n;i++) {
            count[ages[i] - 10]++;
        }
        for(int i=1;i<=range;i++) {
            count[i] += count[i - 1];
        }
        for(int i =n-1;i>=0;i--) {
            output[count[ages[i] - 10] - 1] = ages[i];
            count[ages[i] - 10]--;
        }
        System.out.println("Sorted ages in ascending order:");
        for(int age : output) {
            System.out.print(age + " ");
        }
    }
}