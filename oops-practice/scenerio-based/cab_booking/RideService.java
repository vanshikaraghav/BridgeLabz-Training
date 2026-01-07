package cab_booking;
import java.util.ArrayList;
class RideService {
    ArrayList<Driver> drivers = new ArrayList<>();
    ArrayList<Ride> rides = new ArrayList<>();
    int rideCounter = 1;

    // CREATE
    void addDriver(Driver d) {
        drivers.add(d);
    }

    // READ / CREATE
    Ride bookRide(Userr user, double distance, FareCalculator fareCalculator)
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
                System.out.println("Ride " + rideId + " completed");
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