package hotel_reservation;
import java.util.*;

public class HotelReservationSystem {
	public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        rooms.add(new StandardRoom(101));
        rooms.add(new DeluxeRoom(201));
        Guest guest = new Guest(1, "Harshita");
        try {
            Room selectedRoom = rooms.get(0);
            if(!selectedRoom.available) {
                throw new RoomNotAvailableException("Room is not available");
            }
            selectedRoom.available = false;
            Reservation reservation = new Reservation(guest, selectedRoom, 3);
            reservations.add(reservation);
            System.out.println("Reservation Successful");
            System.out.println("Guest: " + guest.name);
            System.out.println("Room Type: " + selectedRoom.getRoomType());
            System.out.println("Total Bill: " + selectedRoom.calculateBill(3));
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
