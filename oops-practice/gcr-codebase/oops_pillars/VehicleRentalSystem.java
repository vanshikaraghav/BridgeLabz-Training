package encapsulation_and_abstraction;

import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class RentalVehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate; 

    private String insurancePolicyNumber;

    RentalVehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);
}

class RentalCar extends RentalVehicle implements Insurable {

    RentalCar(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

class RentalBike extends RentalVehicle implements Insurable {

    RentalBike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 200;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

class RentalTruck extends RentalVehicle implements Insurable {

    RentalTruck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days + 1000;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance | Policy No: " + getInsurancePolicyNumber();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<RentalVehicle> vehicles = new ArrayList<>();
        vehicles.add(new RentalCar("CAR101", 1500, "Car2234"));
        vehicles.add(new RentalBike("BIKE202", 500, "Bike234"));
        vehicles.add(new RentalTruck("TRUCK303", 3000, "Truk3221"));
        int days = 3;
        for(RentalVehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + days + " days: " + v.calculateRentalCost(days));
            Insurable ins = (Insurable) v;
            System.out.println("Insurance Cost: " + ins.calculateInsurance());
            System.out.println(ins.getInsuranceDetails());
        }
    }
}

