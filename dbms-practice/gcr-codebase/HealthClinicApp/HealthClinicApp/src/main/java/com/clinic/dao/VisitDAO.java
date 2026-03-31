package com.clinic.dao;

import com.clinic.connection.DBConnection;
import java.sql.*;
import java.util.List;

public class VisitDAO {

    // UC-4.1 Record Patient Visit
    public boolean recordVisit(int appointmentId,
                               String diagnosis,
                               String notes,
                               List<String[]> prescriptions) {

        String insertVisit =
            "INSERT INTO visits(appointment_id, diagnosis, notes) VALUES(?,?,?)";

        String updateAppointment =
            "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

        String insertPrescription =
            "INSERT INTO prescriptions(visit_id, medicine_name, dosage, duration) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            // Insert Visit
            PreparedStatement ps1 = conn.prepareStatement(insertVisit,
                    Statement.RETURN_GENERATED_KEYS);

            ps1.setInt(1, appointmentId);
            ps1.setString(2, diagnosis);
            ps1.setString(3, notes);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int visitId = rs.getInt(1);

            // Update appointment status
            PreparedStatement ps2 = conn.prepareStatement(updateAppointment);
            ps2.setInt(1, appointmentId);
            ps2.executeUpdate();

            // UC-4.3 Batch Insert Prescriptions
            PreparedStatement ps3 = conn.prepareStatement(insertPrescription);

            for (String[] pres : prescriptions) {
                ps3.setInt(1, visitId);
                ps3.setString(2, pres[0]); // medicine
                ps3.setString(3, pres[1]); // dosage
                ps3.setString(4, pres[2]); // duration
                ps3.addBatch();
            }

            ps3.executeBatch();

            conn.commit();
            System.out.println("Visit recorded successfully!");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // UC-4.2 View Patient Medical History
    public void viewMedicalHistory(int patientId) {

        String sql =
            "SELECT v.visit_id, v.visit_date, v.diagnosis, d.name AS doctor_name " +
            "FROM visits v " +
            "JOIN appointments a ON v.appointment_id = a.appointment_id " +
            "JOIN doctors d ON a.doctor_id = d.doctor_id " +
            "WHERE a.patient_id = ? " +
            "ORDER BY v.visit_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Visit ID: " + rs.getInt("visit_id"));
                System.out.println("Date: " + rs.getTimestamp("visit_date"));
                System.out.println("Doctor: " + rs.getString("doctor_name"));
                System.out.println("Diagnosis: " + rs.getString("diagnosis"));
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

