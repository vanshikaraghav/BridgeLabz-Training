package com.clinic.dao;

import com.clinic.connection.DBConnection;
import com.clinic.model.Doctor;

import java.sql.*;

public class DoctorDAO {

    public boolean addDoctor(Doctor d) {

        String sql = "INSERT INTO doctors(name,contact,consultation_fee,specialty_id) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setString(2, d.getContact());
            ps.setDouble(3, d.getConsultationFee());
            ps.setInt(4, d.getSpecialtyId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean deactivateDoctor(int doctorId) {

        String futureCheck =
            "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date>=CURDATE()";

        String update = "UPDATE doctors SET is_active=false WHERE doctor_id=?";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps1 = conn.prepareStatement(futureCheck);
            ps1.setInt(1, doctorId);

            ResultSet rs = ps1.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Doctor has future appointments!");
                return false;
            }

            PreparedStatement ps2 = conn.prepareStatement(update);
            ps2.setInt(1, doctorId);

            return ps2.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
