package cab_booking;

class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
