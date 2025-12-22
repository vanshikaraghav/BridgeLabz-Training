package arrays;
import java.util.Scanner;

public class BMIBy2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            double weight = 0, height = 0;
            while (true) {
            	System.out.println("Enter weight: ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Invalid weight.");
            }
            while (true) {
                System.out.print("Enter height (m): ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Invalid height.");
            }
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);
            double bmi = personData[i][2];
            if (bmi < 18.5)
                weightStatus[i] = "Underweight";
            else if (bmi < 24.9)
                weightStatus[i] = "Normal weight";
            else if (bmi < 29.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }
        System.out.println("\nResults:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

	}

}
