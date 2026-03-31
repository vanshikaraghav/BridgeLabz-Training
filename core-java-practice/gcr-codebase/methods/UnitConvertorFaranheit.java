package methods;
import java.util.Scanner;

public class UnitConvertorFaranheit {
	
	public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double fahrenheit = sc.nextDouble();
		double celsius = sc.nextDouble();
		double pounds= sc.nextDouble();
		double kg = sc.nextDouble();
		double gallons = sc.nextDouble();
		double liters = sc.nextDouble();
		System.out.println("Farenheit to Celsius: " + convertFahrenheitToCelsius(fahrenheit));
		System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFahrenheit(celsius));
		System.out.println("Pounds to Kilograms: " + convertPoundsToKilograms(pounds));
		System.out.println("Kilograms to Pounds: " + convertKilogramsToPounds(kg));
		System.out.println("Gallons to Liters: " + convertGallonsToLiters(gallons));
		System.out.println("Liters to Gallons: " + convertLitersToGallons(liters));
	}

}
