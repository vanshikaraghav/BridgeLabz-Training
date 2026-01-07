package cab_booking;

public class CarBookingSystem {
    public static void main(String[] args) {
        RideService service = new RideService();
        service.addDriver(new Driver("Manish"));
        service.addDriver(new Driver("Aryan"));
        Userr user = new Userr("Vanshika");
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