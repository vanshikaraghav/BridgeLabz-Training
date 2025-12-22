package arrays;
import java.util.Scanner;

public class VoteOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int[] age = new int[n];
		for(int i=0;i<age.length;i++) {
			age[i]=sc.nextInt();
		}
		for(int i=0;i<age.length;i++) {
			if(age[i]<0) {
				System.out.println("Invalid age");
			}else if(age[i]>=18) {
				System.out.println("Student can vote");
			}else {
				System.out.println("Student cannot give vote");
			}
		}
	}

}
