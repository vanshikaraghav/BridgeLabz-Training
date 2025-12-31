package constructors_and_variables;

public class HotelBooking {
	
	String guestName;
	String roomType;
	int nights;
	
	HotelBooking() {
        guestName = "Rahul";
        roomType = "Normal AC";
        nights = 1;
    }
	
	HotelBooking(String guestName,String roomType,int nights){
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}
	
	HotelBooking(HotelBooking hotel){
		this.guestName = hotel.guestName;
		this.roomType = hotel.roomType;
		this.nights = hotel.nights;
	}
	
	void display() {
		System.out.println("Guest Name: "+guestName+" | Room-Type: "+roomType+" | Nights: "+nights);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotelBooking h1 = new HotelBooking();
		HotelBooking h2 = new HotelBooking("Aman","Non-AC",2);
		HotelBooking h3 = new HotelBooking(h2);
		h1.display();
		h2.display();
		h3.display();
	}

}
