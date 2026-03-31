package scenerio_based;

class Ticket {
    int price;

    Ticket(int price) {
        this.price = price;
    }
}

class EventManager {
    Ticket[] tickets;
    int size;

    EventManager(int capacity) {
        tickets = new Ticket[capacity];
        size = 0;
    }

    void addTicket(int price) {
        tickets[size++] = new Ticket(price);
    }

    void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    int partition(int low, int high) {
        int pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    void swap(int i, int j) {
        Ticket temp = tickets[i];
        tickets[i] = tickets[j];
        tickets[j] = temp;
    }

    void displayTopCheapest(int k) {
        System.out.println("Top " + k + " Cheapest Tickets:");
        for(int i = 0; i < k && i < size; i++) {
            System.out.println("₹" + tickets[i].price);
        }
    }

    void displayTopExpensive(int k) {
        System.out.println("Top " + k + " Expensive Tickets:");
        for(int i = size - 1; i >= size - k && i >= 0; i--) {
            System.out.println("₹" + tickets[i].price);
        }
    }
}

public class TicketPriceOptimizer {
    public static void main(String[] args) {

        EventManager manager = new EventManager(10);

        manager.addTicket(1200);
        manager.addTicket(450);
        manager.addTicket(3000);
        manager.addTicket(800);
        manager.addTicket(1500);
        manager.addTicket(600);

        manager.quickSort(0, manager.size - 1);

        manager.displayTopCheapest(3);
        manager.displayTopExpensive(3);
    }
}
