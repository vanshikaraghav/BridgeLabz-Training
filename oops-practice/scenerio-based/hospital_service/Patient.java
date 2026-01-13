package hospital_service;
import java.util.*;

public class Patient extends Person {
	private ArrayList<String> medicalHistory = new ArrayList<>();

    Patient(int id, String name) {
        super(id, name);
    }

    public void addHistory(String record) {
        medicalHistory.add(record);
    }

    public void viewHistory() {
        System.out.println("Medical History: " + medicalHistory);
    }
}
