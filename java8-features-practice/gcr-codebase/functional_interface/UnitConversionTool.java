package functional_interface;
interface UnitConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversionTool {
    public static void main(String[] args) {
        double distanceKm = 100;
        double weightKg = 50;
        double miles = UnitConverter.kmToMiles(distanceKm);
        double pounds = UnitConverter.kgToPounds(weightKg);
        System.out.println(distanceKm + " km = " + miles + " miles");
        System.out.println(weightKg + " kg = " + pounds + " lbs");
    }
}
