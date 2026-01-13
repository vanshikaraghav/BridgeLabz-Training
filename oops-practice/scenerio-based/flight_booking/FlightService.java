package flight_booking;
import java.util.*;

class FlightService {

    Flight[] flights;                 
    List<Booking> bookings;           

    FlightService() {
        flights = new Flight[]{
                new Flight(101, "Delhi", "Mumbai", 5500),
                new Flight(102, "Delhi", "Bangalore", 6500),
                new Flight(103, "Mumbai", "Chennai", 6000),
                new Flight(104, "Delhi", "Kolkata", 5000)
        };
        bookings = new ArrayList<>();
    }

    void searchFlight(String source, String destination) {
        boolean found = false;
        for (Flight flight : flights) {
            if (flight.source.equalsIgnoreCase(source)
                    && flight.destination.equalsIgnoreCase(destination)) {
                flight.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found");
        }
    }

    void bookFlight(int flightId, String customerName) {
        for (Flight flight : flights) {
            if (flight.flightId == flightId) {
                bookings.add(new Booking(customerName, flight));
                System.out.println("Flight booked successfully!");
                return;
            }
        }
        System.out.println("Flight ID not found");
    }

    void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available");
            return;
        }
        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }
}
