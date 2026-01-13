package flight_booking;

public class FlightBookingSystem {
	public static void main(String[] args) {
        FlightService service = new FlightService();
        System.out.println(" Searching Flights:");
        service.searchFlight("delhi", "mumbai");
        System.out.println("\n Booking Flight:");
        service.bookFlight(101, "Harshita");
        System.out.println("\n Booking Details:");
        service.displayBookings();
    }
}
