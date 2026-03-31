package hospital_service;

public class Appointment {
	Patient patient;
    Doctor doctor;

    Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    void display() {
        System.out.println("Patient: " + patient.name +" | Doctor: " + doctor.name +" | Fee: " + doctor.calculateConsultationFee());
    }
}
