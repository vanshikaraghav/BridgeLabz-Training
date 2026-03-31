package functional_interface;
interface VehicleDashboard {

	void displaySpeed(int speed);
	default void displayBatteryPercentage(int batteryPercentage) {
		System.out.println("Battery information not available for this vehicle");
	}
}

class PetrolCar implements VehicleDashboard {

	public void displaySpeed(int speed) {
		System.out.println("Petrol Car Speed: " + speed + " km/h");
	}
}

class ElectricCar implements VehicleDashboard {

	public void displaySpeed(int speed) {
		System.out.println("Electric Car Speed: " + speed + " km/h");
	}

	public void displayBatteryPercentage(int batteryPercentage) {
		System.out.println("Battery Level: " + batteryPercentage + "%");
	}
}

public class SmartVehicleDashboard {

	public static void main(String[] args) {

		VehicleDashboard petrolCar = new PetrolCar();
		VehicleDashboard electricCar = new ElectricCar();

		petrolCar.displaySpeed(80);
		petrolCar.displayBatteryPercentage(0);

		electricCar.displaySpeed(65);
		electricCar.displayBatteryPercentage(85);
	}
}