package queue_interface;
import java.util.*;

public class HospitalTriageSystem {
	
	static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }
	
	public static void main(String[] args) {
		PriorityQueue<Patient> pq = new PriorityQueue<>( (a, b) -> b.severity - a.severity);
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));
        System.out.print("Treatment Order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.remove().name + " ");
        }
        System.out.println();
	}
}
