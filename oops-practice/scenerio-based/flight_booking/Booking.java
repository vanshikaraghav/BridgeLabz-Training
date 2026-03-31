package flight_booking;

public class Booking {
	String customerName;
    Flight flight;

    Booking(String customerName, Flight flight) {
        this.customerName = customerName;
        this.flight = flight;
    }

    void displayBooking() {
        System.out.println("Customer: " + customerName);
        flight.display();
    }
}
