package com.clinic.model;

import java.time.LocalDate;

public class Patient {
    private int patientId;
    private String name;
    private LocalDate dob;
    private String phone;
    private String email;
    private String address;
    private String bloodGroup;

    public Patient() {}

    public Patient(String name, LocalDate dob, String phone,
                   String email, String address, String bloodGroup) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int id) { this.patientId = id; }

    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getBloodGroup() { return bloodGroup; }

    public void setName(String name) { this.name = name; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String toString() {
        return patientId + " | " + name + " | " + phone + " | " + email;
    }
}
