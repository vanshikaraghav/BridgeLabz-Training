package linkedlist;
import java.util.*;

class Ticket {
    String ticketId, customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;

    void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
            return;
        }
        Ticket temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newTicket;
        newTicket.next = head;
    }

    void removeTicket(String ticketId) {
        if (head == null) return;
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId.equals(ticketId)) {
                if (prev == null) {
                    if (head.next == head) {
                        head = null;
                        return;
                    }
                    Ticket last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String customerName) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName))
                System.out.println("ID: " + temp.ticketId + ", Movie: " + temp.movieName);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByMovie(String movieName) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName))
                System.out.println("ID: " + temp.ticketId + ", Customer: " + temp.customerName);
            temp = temp.next;
        } while (temp != head);
    }

    int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("1.Add 2.Remove 3.Display 4.SearchCustomer 5.SearchMovie 6.Count 0.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    String id = sc.nextLine();
                    System.out.print("Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, cname, mname, seat, time);
                    break;
                case 2:
                    System.out.print("Ticket ID to remove: ");
                    String rid = sc.nextLine();
                    system.removeTicket(rid);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Customer Name: ");
                    String searchC = sc.nextLine();
                    system.searchByCustomer(searchC);
                    break;
                case 5:
                    System.out.print("Movie Name: ");
                    String searchM = sc.nextLine();
                    system.searchByMovie(searchM);
                    break;
                case 6:
                    System.out.println("Total Tickets: " + system.countTickets());
                    break;
            }
        }
        sc.close();
    }
}