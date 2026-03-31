package methods;
import java.util.Scanner;

public class UnitConvertor {
	
	 public static double convertKmToMiles(double km) {
	        return km * 0.621371;
	    }

	 public static double convertMilesToKm(double miles) {
	        return miles * 1.60934;
	    }
	 
	 public static double convertMetersToFeet(double meters) {
	        return meters * 3.28084;
	    }

	 public static double convertFeetToMeters(double feet) {
	        return feet * 0.3048;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double km = sc.nextDouble();
		double miles = sc.nextDouble();
		double meters = sc.nextDouble();
		double feet = sc.nextDouble();
		System.out.println("km to miles: " + convertKmToMiles(km));
        System.out.println("miles to km: " + convertMilesToKm(miles));
        System.out.println("meters to feet: " + convertMetersToFeet(meters));
        System.out.println("feet to meters: " + convertFeetToMeters(feet));
	}

}
