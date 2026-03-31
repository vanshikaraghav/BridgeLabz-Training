package scenario_based;
import java.util.*;

class TableAlreadyReservedException extends Exception {
	public TableAlreadyReservedException(String message) {
		super(message);
    }
}

class Table {
    int tableNumber;
    int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }
}
  
class Reservation {
    int tableNumber;
    String timeSlot;
    String customerName;

    public Reservation(int tableNumber, String timeSlot, String customerName) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
        this.customerName = customerName;
    }
}

class RestaurantReservationSystem {
    Map<Integer, Table> tables = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

   public void addTable(Table table) {
       tables.put(table.tableNumber, table);
   }

   public void reserveTable(int tableNumber, String timeSlot, String customerName) throws TableAlreadyReservedException {
     for(Reservation r : reservations) {
         if(r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
             throw new TableAlreadyReservedException("Table already reserved for this time slot!");
         }
     }
     reservations.add(new Reservation(tableNumber, timeSlot, customerName));
     System.out.println("Reservation successful for " + customerName);
   }

   public void cancelReservation(int tableNumber, String timeSlot) {
       reservations.removeIf(r -> r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot));
       System.out.println("Reservation cancelled");
   }

   public void showAvailableTables(String timeSlot) {
       System.out.println("Available tables at " + timeSlot + ":");
       for(Integer tableNo : tables.keySet()) {
           boolean reserved = false;
           for(Reservation r : reservations) {
               if(r.tableNumber == tableNo && r.timeSlot.equals(timeSlot)) {
                  reserved = true;
                  break;
               }
           }
           if(!reserved) {
              System.out.println("Table " + tableNo);
           }
       }
   }
}

//Main
public class RestaurantTableReservation {
 public static void main(String[] args) {
     RestaurantReservationSystem system = new RestaurantReservationSystem();

     system.addTable(new Table(1, 4));
     system.addTable(new Table(2, 2));
     system.addTable(new Table(3, 6));

     try {
         system.reserveTable(1, "7PM-9PM", "Alice");
         system.reserveTable(2, "7PM-9PM", "Bob");
         system.reserveTable(1, "7PM-9PM", "Charlie"); // Exception
     } catch (TableAlreadyReservedException e) {
         System.out.println(e.getMessage());
     }

     system.showAvailableTables("7PM-9PM");
 }
}
