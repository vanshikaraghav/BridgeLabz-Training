package com.clinic.dao;

import com.clinic.connection.DBConnection;
import java.sql.*;

public class AppointmentDAO {

    public boolean book(int patientId, int doctorId,
                        Date date, Time time) {

        String check =
            "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=?";

        String insert =
            "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(check);
            ps1.setInt(1, doctorId);
            ps1.setDate(2, date);
            ps1.setTime(3, time);

            ResultSet rs = ps1.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                conn.rollback();
                System.out.println("Slot booked!");
                return false;
            }

            PreparedStatement ps2 = conn.prepareStatement(insert);
            ps2.setInt(1, patientId);
            ps2.setInt(2, doctorId);
            ps2.setDate(3, date);
            ps2.setTime(4, time);
            ps2.setString(5, "SCHEDULED");

            ps2.executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean cancel(int appointmentId) {

        String update =
            "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";

        String audit =
            "INSERT INTO appointment_audit(appointment_id,action) VALUES(?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(update);
            ps1.setInt(1, appointmentId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(audit);
            ps2.setInt(1, appointmentId);
            ps2.setString(2, "CANCELLED");
            ps2.executeUpdate();

            conn.commit();
            return true;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
