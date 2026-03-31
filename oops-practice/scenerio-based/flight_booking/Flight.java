package flight_booking;

class Flight {
    int flightId;
    String source;
    String destination;
    double price;

    Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    void display() {
        System.out.println("Flight ID: " + flightId +
                " | From: " + source +
                " | To: " + destination +
                " | Price: ₹" + price);
    }
}

