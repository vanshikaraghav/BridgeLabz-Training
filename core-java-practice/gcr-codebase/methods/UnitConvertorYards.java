package methods;
import java.util.Scanner;

public class UnitConvertorYards {
	
	public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner sc = new Scanner(System.in);
		double yards = sc.nextDouble();
		double feet = sc.nextDouble();
		double meters = sc.nextDouble();
		double inchesM = sc.nextDouble();
		double inchesCm = sc.nextDouble();
		System.out.println("Yards to feet is: "+convertYardsToFeet(yards));
        System.out.println("Feets to yards is: "+convertFeetToYards(feet));
        System.out.println("Meters to inches is: "+convertMetersToInches(meters));
        System.out.println("Inches to meters is: "+convertInchesToMeters(inchesM));
        System.out.println("Inches to cm is: "+convertInchesToCentimeters(inchesCm));
	}

}
