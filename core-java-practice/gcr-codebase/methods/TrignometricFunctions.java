package methods;
import java.util.Scanner;

public class TrignometricFunctions {
	
	public static double[] calculateTrigonometricFunctions(double angle) {
		double radians = Math.toRadians(angle);
	    double sin = Math.sin(radians);
	    double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double angle = sc.nextDouble();
		double[] ans = calculateTrigonometricFunctions(angle);
		System.out.println("sin is: "+ans[0]);
		System.out.println("cos is: "+ans[1]);
		System.out.println("tan is: " +ans[2]);
	}

}
