package built_in_Functions;
import java.util.Scanner;

public class TempratureConvertor {
	
	public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double fahrenheit = sc.nextDouble();
		double celsius = sc.nextDouble();
		System.out.println("Farenheit to Celsius: " + convertFahrenheitToCelsius(fahrenheit));
		System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFahrenheit(celsius));
	}

}
