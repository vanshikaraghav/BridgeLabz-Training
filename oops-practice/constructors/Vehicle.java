package constructors_and_variables;

public class Vehicle {
	
	String ownerName;
	String vehicleType;
	static double registerationfee = 3000;
	
	Vehicle(String ownerName,String vehicleType){
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}
	
	void displayVehicleDetails() {
		System.out.println("Owner: "+ownerName+" | Vehicle: "+vehicleType+" | Registeration fees: "+registerationfee);
	}
	
	void updateRegisterationFee(double fee) {
		registerationfee = fee;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v1 = new Vehicle("Aman","Bike");
		v1.displayVehicleDetails();
		v1.updateRegisterationFee(4000);
		v1.displayVehicleDetails();
	}

}
