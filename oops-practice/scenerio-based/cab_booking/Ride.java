package cab_booking;

class Ride {
	int rideId;
    Userr user;
    Driver driver;
    double distance;
    double fare;

    Ride(Userr user, Driver driver, double distance, double fare, int rideId) {
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