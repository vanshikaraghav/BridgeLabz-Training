package arrays;
import java.util.Scanner;

public class NumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				if(nums[i]%2==0) {
					System.out.println(nums[i]+" is even positive number");
				}else {
					System.out.println(nums[i]+" is odd positive number");
				}
			}else if(nums[i]<0) {
				System.out.println(nums[i]+" is a Negative number");
			}else {
				System.out.println("Zero");
			}
		}
		if(nums[0]==nums[4]) {
			System.out.println("First and Last Numbers are equal");
		}else if(nums[0]>nums[4]) {
			System.out.println("First Number is largest");
		}else {
			System.out.println("Last is largest");
		}
	}

}
