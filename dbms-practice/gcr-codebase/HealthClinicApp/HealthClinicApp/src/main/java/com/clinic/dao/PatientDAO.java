package com.clinic.dao;

import com.clinic.connection.DBConnection;
import com.clinic.model.Patient;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PatientDAO {

    // UC-1.1 Register
    public boolean register(Patient p) {

        String check = "SELECT COUNT(*) FROM patients WHERE phone=? OR email=?";
        String insert = "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps1 = conn.prepareStatement(check);
            ps1.setString(1, p.getPhone());
            ps1.setString(2, p.getEmail());

            ResultSet rs = ps1.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Duplicate patient!");
                return false;
            }

            PreparedStatement ps2 = conn.prepareStatement(insert);
            ps2.setString(1, p.getName());
            ps2.setDate(2, Date.valueOf(p.getDob()));
            ps2.setString(3, p.getPhone());
            ps2.setString(4, p.getEmail());
            ps2.setString(5, p.getAddress());
            ps2.setString(6, p.getBloodGroup());

            ps2.executeUpdate();
            return true;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // UC-1.3 Search by name
    public List<Patient> searchByName(String name) {

        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob").toLocalDate());
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));
                list.add(p);
            }

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
