package inheritance;

//Superclass
class Vehicle
{
	 int maxSpeed;
	 String fuelType;
	
	 // Constructor
	 Vehicle(int maxSpeed, String fuelType)
	 {
	     this.maxSpeed = maxSpeed;
	     this.fuelType = fuelType;
	 }
	
	 // Method to display vehicle information
	 void displayInfo()
	 {
	     System.out.println("Max Speed : " + maxSpeed + " km/h");
	     System.out.println("Fuel Type : " + fuelType);
	 }
}

//Subclass Car
class Car extends Vehicle
{
	 int seatCapacity;
	
	 Car(int maxSpeed, String fuelType, int seatCapacity)
	 {
	     super(maxSpeed, fuelType);
	     this.seatCapacity = seatCapacity;
	 }
	
	 // Overriding displayInfo()
	 void displayInfo()
	 {
	     super.displayInfo();
	     System.out.println("Seat Capacity : " + seatCapacity);
	    
	 }
}

//Subclass Truck
class Truck extends Vehicle
{
	 int loadCapacity;   // in tons
	
	 Truck(int maxSpeed, String fuelType, int loadCapacity)
	 {
	     super(maxSpeed, fuelType);
	     this.loadCapacity = loadCapacity;
	 }
	
	 // Overriding displayInfo()
	 void displayInfo()
	 {
	     super.displayInfo();
	     System.out.println("Load Capacity : " + loadCapacity + " tons");

	 }
}

//Subclass Motorcycle
class Motorcycle extends Vehicle
{
	 boolean hasGear;
	
	 Motorcycle(int maxSpeed, String fuelType, boolean hasGear)
	 {
	     super(maxSpeed, fuelType);
	     this.hasGear = hasGear;
	 }
	
	 //Overriding 
	 void displayInfo()
	 {
	     super.displayInfo();
	     System.out.println("Has Gear :-" + hasGear);
	    
	 }
}

//Main
public class VehicleManagementSystem 
{
	
	public static void main(String[] args)
    {
        // Polymorphism
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new Motorcycle(150, "Petrol", true);

        //Display information of all vehicles
        for (Vehicle v : vehicles)
        {
            v.displayInfo();
        }
    }
	
	

}