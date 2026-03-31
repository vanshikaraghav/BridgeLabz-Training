package scenario_based;
import java.util.LinkedList;
import java.util.Queue;

//Vehicle Node (Circular Linked List)
class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

// Roundabout using Circular Linked List
class Roundabout {
    private Vehicle head = null;

    public void addVehicle(Vehicle v) {
        if(head == null) {
            head = v;
            v.next = head;
            return;
        }
        Vehicle temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        temp.next = v;
        v.next = head;
    }

    public void removeVehicle() {
        if(head == null) {
            System.out.println("Roundabout empty");
            return;
        }
        if(head.next == head) {
            System.out.println("Vehicle exited: " + head.number);
            head = null;
            return;
        }
        Vehicle temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        System.out.println("Vehicle exited: " + head.number);
        temp.next = head.next;
        head = head.next;
    }

    public void display() {
        if(head == null) {
            System.out.println("Roundabout empty");
            return;
        }
        Vehicle temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("(back to start)");
    }
}

// Main
public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        Queue<Vehicle> waitingQueue = new LinkedList<>();
        int MAX_QUEUE = 3;
        if(waitingQueue.size() < MAX_QUEUE) {
            waitingQueue.add(new Vehicle("CAR-101"));
        }else {
            System.out.println("Queue Overflow");
        }
        waitingQueue.add(new Vehicle("CAR-102"));
        waitingQueue.add(new Vehicle("CAR-103"));
        while(!waitingQueue.isEmpty()) {
            roundabout.addVehicle(waitingQueue.poll());
        }
        roundabout.display();
        roundabout.removeVehicle();
        roundabout.display();
    }
}
