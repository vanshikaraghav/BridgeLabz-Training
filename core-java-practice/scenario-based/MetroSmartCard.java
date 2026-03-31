package scenario_based;

import java.util.Scanner;
public class MetroSmartCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double balance = 100; 
        int distance;
        while(balance>0) {
            System.out.println("\nCurrent Balance: ₹" + balance);
            System.out.print("Enter distance (or -1 to quit): ");
            distance = sc.nextInt();
            if(distance == -1) {
                break;
            }
            int fare = (distance<=5) ? 10 : 20; 
            if(balance>=fare) {
                balance -= fare;
                System.out.println("Fare deducted: ₹" + fare);
            }else{
                System.out.println("Insufficient balance!");
                break;
            }
        }
        System.out.println("\nThank you for using Delhi Metro");
	}

}
