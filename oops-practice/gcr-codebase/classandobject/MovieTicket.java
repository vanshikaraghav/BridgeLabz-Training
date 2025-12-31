package class_and_objects;

public class MovieTicket {
	
	String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    void bookTicket(String movie,String seat,double ticketPrice) {
        if(!isBooked) {
        	movieName = movie;
            seatNumber = seat;
            price = ticketPrice;
            isBooked = true;
            System.out.println("Ticket booked for movie: "+movieName);
            System.out.println("Seat Number: "+seatNumber);
        }else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    void displayTicketDetails() {
        if(isBooked) {
            System.out.println("Price: $"+price);
        }else {
            System.out.println("Ticket have not booked yet...");
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieTicket ticket = new MovieTicket();
        ticket.displayTicketDetails();
        ticket.bookTicket("Dragon","A10",120.0);
        ticket.bookTicket("Dragon","A10",120.0);
        ticket.bookTicket("Dragon","A10",120.0);
        ticket.displayTicketDetails();
	}

}
