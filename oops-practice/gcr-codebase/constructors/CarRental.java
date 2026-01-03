package constructors_and_variables;

public class CarRental {
	
	String customerName;
	String carModel;
	int rentalDays;
	
	CarRental(String customerName,String carModel,int rentalDays){
		this.customerName = customerName;
		this.carModel = carModel;
		this.rentalDays = rentalDays;
	}
	
	double calculateTotalCost() {
		double costPerDay = 2000;
		double totalCost = costPerDay*rentalDays;
		return totalCost;
	}
	
	void display() {
		System.out.println("Customer Name: "+customerName+" | Model: "+carModel+" | Rental Days: "+rentalDays);
		System.out.println("Total Cost: "+calculateTotalCost());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarRental car = new CarRental("Aman","Scorpio-N",5);
		car.display();
	}

}
