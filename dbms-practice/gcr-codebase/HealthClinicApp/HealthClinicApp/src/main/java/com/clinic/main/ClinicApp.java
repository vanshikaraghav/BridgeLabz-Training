package com.clinic.main;

import com.clinic.dao.*;
import com.clinic.model.*;

import java.time.LocalDate;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class ClinicApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        VisitDAO visitDAO = new VisitDAO();
        BillingDAO billingDAO = new BillingDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("        HEALTH CLINIC SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Register Patient (UC-1.1)");
            System.out.println("2. Search Patient (UC-1.3)");
            System.out.println("3. Add Doctor (UC-2.1)");
            System.out.println("4. Deactivate Doctor (UC-2.4)");
            System.out.println("5. Book Appointment (UC-3.1)");
            System.out.println("6. Cancel Appointment (UC-3.3)");
            System.out.println("7. Record Visit (UC-4.1 & 4.3)");
            System.out.println("8. View Medical History (UC-4.2)");
            System.out.println("9. Generate Bill (UC-5.1)");
            System.out.println("10. Record Payment (UC-5.2)");
            System.out.println("11. View Outstanding Bills (UC-5.3)");
            System.out.println("12. Revenue Report (UC-5.4)");
            System.out.println("13. Exit");

            System.out.print("Choose option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // =======================
                // PATIENT MANAGEMENT
                // =======================
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("DOB (YYYY-MM-DD): ");
                    LocalDate dob = LocalDate.parse(sc.nextLine());

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("Blood Group: ");
                    String blood = sc.nextLine();

                    Patient p = new Patient(name, dob, phone, email, address, blood);

                    if (patientDAO.register(p))
                        System.out.println("Patient registered successfully!");
                    else
                        System.out.println("Registration failed.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();

                    List<Patient> list = patientDAO.searchByName(search);
                    if (list.isEmpty())
                        System.out.println("No patients found.");
                    else
                        list.forEach(System.out::println);
                    break;

                // =======================
                // DOCTOR MANAGEMENT
                // =======================
                case 3:
                    System.out.print("Doctor Name: ");
                    String dname = sc.nextLine();

                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    System.out.print("Consultation Fee: ");
                    double fee = Double.parseDouble(sc.nextLine());

                    System.out.print("Specialty ID: ");
                    int sid = Integer.parseInt(sc.nextLine());

                    Doctor doctor = new Doctor(dname, contact, fee, sid);

                    if (doctorDAO.addDoctor(doctor))
                        System.out.println("Doctor added successfully!");
                    else
                        System.out.println("Failed to add doctor.");
                    break;

                case 4:
                    System.out.print("Doctor ID to deactivate: ");
                    int docId = Integer.parseInt(sc.nextLine());

                    if (doctorDAO.deactivateDoctor(docId))
                        System.out.println("Doctor deactivated.");
                    else
                        System.out.println("Cannot deactivate doctor.");
                    break;

                // =======================
                // APPOINTMENT
                // =======================
                case 5:
                    System.out.print("Patient ID: ");
                    int patientId = Integer.parseInt(sc.nextLine());

                    System.out.print("Doctor ID: ");
                    int doctorId = Integer.parseInt(sc.nextLine());

                    System.out.print("Date (YYYY-MM-DD): ");
                    Date date = Date.valueOf(sc.nextLine());

                    System.out.print("Time (HH:MM:SS): ");
                    Time time = Time.valueOf(sc.nextLine());

                    if (appointmentDAO.book(patientId, doctorId, date, time))
                        System.out.println("Appointment booked!");
                    else
                        System.out.println("Booking failed.");
                    break;

                case 6:
                    System.out.print("Appointment ID to cancel: ");
                    int appId = Integer.parseInt(sc.nextLine());

                    if (appointmentDAO.cancel(appId))
                        System.out.println("Appointment cancelled.");
                    else
                        System.out.println("Cancellation failed.");
                    break;

                // =======================
                // VISIT & PRESCRIPTION
                // =======================
                case 7:
                    System.out.print("Appointment ID: ");
                    int appointmentId = Integer.parseInt(sc.nextLine());

                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.nextLine();

                    System.out.print("Notes: ");
                    String notes = sc.nextLine();

                    List<String[]> prescriptions = new ArrayList<>();

                    while (true) {
                        System.out.print("Medicine name (or type done): ");
                        String med = sc.nextLine();
                        if (med.equalsIgnoreCase("done")) break;

                        System.out.print("Dosage: ");
                        String dosage = sc.nextLine();

                        System.out.print("Duration: ");
                        String duration = sc.nextLine();

                        prescriptions.add(new String[]{med, dosage, duration});
                    }

                    if (visitDAO.recordVisit(appointmentId, diagnosis, notes, prescriptions))
                        System.out.println("Visit recorded.");
                    else
                        System.out.println("Visit failed.");
                    break;

                case 8:
                    System.out.print("Patient ID: ");
                    int pid = Integer.parseInt(sc.nextLine());
                    visitDAO.viewMedicalHistory(pid);
                    break;

                // =======================
                // BILLING
                // =======================
                case 9:
                    System.out.print("Visit ID: ");
                    int visitId = Integer.parseInt(sc.nextLine());
                    billingDAO.generateBill(visitId);
                    break;

                case 10:
                    System.out.print("Bill ID: ");
                    int billId = Integer.parseInt(sc.nextLine());

                    System.out.print("Payment Mode: ");
                    String mode = sc.nextLine();

                    billingDAO.recordPayment(billId, mode);
                    break;

                case 11:
                    billingDAO.viewOutstandingBills();
                    break;

                case 12:
                    System.out.print("Start Date (YYYY-MM-DD): ");
                    String start = sc.nextLine();

                    System.out.print("End Date (YYYY-MM-DD): ");
                    String end = sc.nextLine();

                    billingDAO.revenueReport(start, end);
                    break;

                case 13:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
