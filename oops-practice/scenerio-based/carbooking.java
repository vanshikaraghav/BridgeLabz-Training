package scenerio_based;

import java.util.ArrayList;

// User class
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

// Driver class
class Driver {
    String name;
    boolean available;

    Driver(String name) {
        this.name = name;
        this.available = true;
    }
}

// Interface
interface FareCalculator {
    double calculateFare(double distance);
}

// Normal Fare
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

// Peak Fare
class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// Ride class
class Ride {
	int rideId;
    User user;
    Driver driver;
    double distance;
    double fare;

    Ride(User user, Driver driver, double distance, double fare, int rideId) {
    	this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }

    void displayRide() {
        System.out.println("RideId: "+rideId+" | User: "+user.name +" | Driver: "+driver.name +" | Distance: "+distance +" | Fare: ₹"+fare);
    }
}

// Custom Exception
class NoDriverAvailableException extends Exception {
    NoDriverAvailableException(String msg) {
        super(msg);
    }
}

// Ride Service (CRUD)
class RideService {
    ArrayList<Driver> drivers = new ArrayList<>();
    ArrayList<Ride> rides = new ArrayList<>();
    int rideCounter = 1;

    // CREATE
    void addDriver(Driver d) {
        drivers.add(d);
    }

    // READ / CREATE
    Ride bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        Driver assigned = null;

        for (Driver d : drivers) {
            if (d.available) {
                assigned = d;
                d.available = false;
                break;
            }
        }

        if (assigned == null) {
            throw new NoDriverAvailableException("No Driver Available!");
        }

        double fare = fareCalculator.calculateFare(distance);
        Ride ride = new Ride(user, assigned, distance, fare, rideCounter);
        rides.add(ride);
        return ride;
    }

    // READ
    void showRideHistory() {
        for (Ride r : rides) {
            r.displayRide();
        }
    }

    // UPDATE
    void completeRide(int rideId) {
        for (Ride r : rides) {
            if (r.rideId == rideId) {
                r.driver.available = true;
                System.out.println("Ride " + rideId + " finished");
                return;
            }
        }
    }

    // DELETE
    void cancelRide(int rideId) {
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).rideId == rideId) {
                rides.get(i).driver.available = true;
                rides.remove(i);
                System.out.println("Ride " + rideId + " cancelled");
                return;
            }
        }
    }
}

// MAIN CLASS
public class carbooking {
    public static void main(String[] args) {
        RideService service = new RideService();
        service.addDriver(new Driver("Manish"));
        service.addDriver(new Driver("Aryan"));
        User user = new User("Harshita");
        try {
            Ride r1 = service.bookRide(user, 10, new NormalFare());
            r1.displayRide();
            Ride r2 = service.bookRide(user, 8, new PeakFare());
            r2.displayRide();
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nRide History\n");
        service.showRideHistory();
    }
}