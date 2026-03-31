package arrays;
import java.util.Scanner;

public class OddEvenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number<=0) {
            System.out.println("Not a natural no.");
            return;
        }
        int[] odd = new int[number/2+1];
        int[] even = new int[number/2+1];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 1;i<=number;i++) {
            if (i%2==0) {
                even[evenIndex++]=i;
            } else {
                odd[oddIndex++]=i;
            }
        }
        for (int i=0;i<oddIndex;i++) {
            System.out.print("Odd Numbers: "+odd[i]+" ");
        }
        for (int i=0;i<evenIndex;i++) {
            System.out.print("Even Numbers: "+even[i]+" ");
        }
	}

}
