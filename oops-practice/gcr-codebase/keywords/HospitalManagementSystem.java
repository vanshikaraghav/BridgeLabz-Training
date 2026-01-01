package this_static_final_instance;

class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    final String patientID;
    String name;
    int age;
    String ailment;

    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: "+totalPatients);
    }

    void displayPatient(Object obj) {
        if(obj instanceof Patient) {
            System.out.println("Hospital Name: "+hospitalName);
            System.out.println("Patient ID: "+patientID);
            System.out.println("Name: "+name);
            System.out.println("Age: "+age);
            System.out.println("Ailment: "+ailment);
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient pt1 = new Patient("P001","Lathika",30,"Flu");
        Patient pt2 = new Patient("P002","Lidiya",45,"Fracture");
        Patient.getTotalPatients();
        pt1.displayPatient(pt1);
        pt2.displayPatient(pt2);
    }
}
