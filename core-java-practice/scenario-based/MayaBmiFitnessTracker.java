package scenario_based;
import java.util.Scanner;

public class MayaBmiFitnessTracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double heightMeters = sc.nextDouble();
        double weightKg = sc.nextDouble();
        double bmi = weightKg / (heightMeters * heightMeters);
        System.out.println("Your BMI is: " + bmi);
        if (bmi<18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi>=18.5 && bmi<25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }
	}

}
