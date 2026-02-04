package functional_interface;

interface Vehicle{
	void rent();
	void returnVechicle();
}

class cars implements Vehicle{
	public void rent() {
		System.out.println("Car is on rent");
	}
	public void returnVechicle() {
		System.out.println("Car is available");
	}
}


class bikes implements Vehicle{
	public void rent() {
		System.out.println("Bike is on rent");
	}
	public void returnVechicle() {
		System.out.println("Bike is available");
	}
}

class bus implements Vehicle{
	public void rent() {
		System.out.println("Bus is on rent");
	}
	public void returnVechicle() {
		System.out.println("Bus is available");
	}
}
public class MultiVehicleRentalSystem {
	public static void main(String[] args) {
		
		Vehicle car = new cars();
		Vehicle bike = new bikes();
		Vehicle bus = new bus();
		
		car.rent();
		bike.rent();
		bus.rent();
		
		car.returnVechicle();
		bike.returnVechicle();
		bus.returnVechicle();
		
	}
}