package inheritance;

class Vehicles
{
    String model;
    int maxSpeed;

    Vehicles(String model, int maxSpeed)
    {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayVehicleInfo()
    {
        System.out.println("Model: " + model);
        System.out.println("Max Speed:-" + maxSpeed + " km/h");
    }
}

//Interface
interface Refuelable
{
    void refuel();
}

//Electric Vehicle
class ElectricVehicle extends Vehicles
{
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity)
    {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge()
    {
        System.out.println("Electric vehicle is charging");
    }

    void displayInfo()
    {
        System.out.println("Vehicle Type: Electric Vehicle");
        displayVehicleInfo();
        System.out.println("Battery Capacity:-" + batteryCapacity + " kWh");
        charge();
    }
}

//Petrol Vehicle
class PetrolVehicle extends Vehicles implements Refuelable
{
    int fuelTankCapacity;

    PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity)
    {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    

    @Override
	public void refuel() {
		// TODO Auto-generated method stub
    	System.out.println("Petrol vehicle is refueling");
		
	}



	void displayInfo()
    {
        System.out.println("Vehicle Type: Petrol Vehicle");
        displayVehicleInfo();
        System.out.println("Fuel Tank Capacity:-" + fuelTankCapacity + " liters");
        refuel();
    }
}

//Main class
public class VehicleAndTransportSystem
{
    public static void main(String[] args)
    {
        ElectricVehicle ev = new ElectricVehicle("Tesla", 180, 75);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 160, 40);

        System.out.println();
        ev.displayInfo();

        System.out.println();
        pv.displayInfo();
    }
}