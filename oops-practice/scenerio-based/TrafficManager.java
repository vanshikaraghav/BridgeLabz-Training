package scenerio_based;

class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}

class VehicleQueue {
    String[] queue;
    int front = 0, rear = -1, size, capacity;

    VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return front > rear;
    }

    void enqueue(String vehicle) {
        if (isFull()) {
            System.out.println("Queue Overflow: Vehicle cannot enter now");
            return;
        }
        queue[++rear] = vehicle;
    }

    String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No waiting vehicles");
            return null;
        }
        return queue[front++];
    }
}

class Roundabout {
    Vehicle tail = null;

    void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        System.out.println(number + " entered roundabout");
    }

    void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout empty");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            tail = null;
        } else {
            tail.next = head.next;
        }
        System.out.println(head.number + " exited roundabout");
    }

    void display() {
        if (tail == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        Vehicle temp = tail.next;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(back to start)");
    }
}

public class TrafficManager {
	public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);
        queue.enqueue("CAR-101");
        queue.enqueue("CAR-102");
        queue.enqueue("CAR-103");
        roundabout.addVehicle(queue.dequeue());
        roundabout.addVehicle(queue.dequeue());
        roundabout.display();
        roundabout.removeVehicle();
        roundabout.addVehicle(queue.dequeue());
        roundabout.display();
    }
}
