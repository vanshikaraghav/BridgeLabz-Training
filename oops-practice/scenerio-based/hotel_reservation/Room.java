package hotel_reservation;

abstract class Room {
    int roomNumber;
    double pricePerDay;
    boolean available = true;
    PricingStrategy pricingStrategy;

    Room(int roomNumber, double pricePerDay, PricingStrategy pricingStrategy) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
        this.pricingStrategy = pricingStrategy;
    }

    abstract String getRoomType();

    double calculateBill(int days) {
        return pricingStrategy.calculatePrice(pricePerDay, days);
    }
}

class StandardRoom extends Room {
    StandardRoom(int roomNumber) {
        super(roomNumber, 2000, new SeasonalPricing());
    }

    String getRoomType() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int roomNumber) {
        super(roomNumber, 4000, new SeasonalPricing());
    }

    String getRoomType() {
        return "Deluxe Room";
    }
}