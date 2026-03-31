package hospital_service;

public class Doctor extends Person implements HospitalService {
    private String specialization;

    Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public double calculateConsultationFee() {
        return specialization.equalsIgnoreCase("Surgeon") ? 1000 : 500;
    }
}
