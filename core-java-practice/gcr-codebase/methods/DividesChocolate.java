 package methods;
import java.util.Scanner;

public class DividesChocolate {
	
	public static int[] divideChocolates(int numberOfChocolates, int numberOfChildren) {
		int chocolatesPerChild = numberOfChocolates/numberOfChildren;
        int remainingChocolate = numberOfChocolates%numberOfChildren;
        return new int[]{chocolatesPerChild, remainingChocolate};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numberOfChocolates = sc.nextInt();
		int numberOfChildern = sc.nextInt();
		int[] ans = divideChocolates(numberOfChocolates,numberOfChildern);
		System.out.println("Chocolates each child gets are: "+ans[0]);
		System.out.println("remaining are: "+ans[1]);
	}

}
