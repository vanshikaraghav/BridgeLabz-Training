package hospital_service;

public class HospitalManagementSystem {
	public static void main(String[] args) throws AppointmentNotAvailableException {

        Patient p1 = new Patient(1, "Harshita");
        Doctor d1 = new Doctor(101, "Dr. Sharma", "Surgeon");
        Appointment app = new Appointment(p1, d1);
        app.display();
        p1.addHistory("Fever");
        p1.addHistory("Blood Test");
        p1.viewHistory();
    }
}
