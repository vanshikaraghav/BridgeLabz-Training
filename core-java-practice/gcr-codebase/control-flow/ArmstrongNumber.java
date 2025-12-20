package control_flow;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int number = sc.nextInt();
	        int originalNumber = number;
	        int sum = 0;
	        while (originalNumber != 0) {
	            int digit = originalNumber%10;  
	            sum = sum + (digit * digit * digit);  
	            originalNumber = originalNumber/10;
	        }
	        if (sum==number) {
	            System.out.println("Armstrong Number");
	        } else {
	            System.out.println("Not an Armstrong Number");
	        }
	}

}
