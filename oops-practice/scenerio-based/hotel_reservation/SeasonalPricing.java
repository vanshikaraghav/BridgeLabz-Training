package hotel_reservation;

class SeasonalPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days * 1.2;
    }
}