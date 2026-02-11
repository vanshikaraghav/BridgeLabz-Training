package com.clinic.dao;

import com.clinic.connection.DBConnection;
import java.sql.*;

public class BillingDAO {

    // =============================
    // UC-5.1 Generate Bill
    // =============================
    public boolean generateBill(int visitId) {

        String feeQuery =
            "SELECT d.consultation_fee " +
            "FROM visits v " +
            "JOIN appointments a ON v.appointment_id = a.appointment_id " +
            "JOIN doctors d ON a.doctor_id = d.doctor_id " +
            "WHERE v.visit_id=?";

        String insertBill =
            "INSERT INTO bills(visit_id,total_amount) VALUES(?,?)";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement ps1 = conn.prepareStatement(feeQuery);
            ps1.setInt(1, visitId);

            ResultSet rs = ps1.executeQuery();
            if (!rs.next()) {
                System.out.println("Visit not found!");
                return false;
            }

            double fee = rs.getDouble(1);

            PreparedStatement ps2 = conn.prepareStatement(insertBill);
            ps2.setInt(1, visitId);
            ps2.setDouble(2, fee);
            ps2.executeUpdate();

            System.out.println("Bill generated. Amount: " + fee);
            return true;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    // =============================
    // UC-5.2 Record Payment
    // =============================
    public boolean recordPayment(int billId, String mode) {

        String updateBill =
            "UPDATE bills SET payment_status='PAID', payment_date=CURDATE(), payment_mode=? WHERE bill_id=?";

        String insertTransaction =
            "INSERT INTO payment_transactions(bill_id,amount,payment_mode) " +
            "SELECT bill_id,total_amount,? FROM bills WHERE bill_id=?";

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            PreparedStatement ps1 = conn.prepareStatement(updateBill);
            ps1.setString(1, mode);
            ps1.setInt(2, billId);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(insertTransaction);
            ps2.setString(1, mode);
            ps2.setInt(2, billId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Payment recorded.");
            return true;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    // =============================
    // UC-5.3 Outstanding Bills
    // =============================
    public void viewOutstandingBills() {

        String sql =
            "SELECT p.name, COUNT(b.bill_id) AS total_bills, SUM(b.total_amount) AS total_due " +
            "FROM bills b " +
            "JOIN visits v ON b.visit_id = v.visit_id " +
            "JOIN appointments a ON v.appointment_id = a.appointment_id " +
            "JOIN patients p ON a.patient_id = p.patient_id " +
            "WHERE b.payment_status='UNPAID' " +
            "GROUP BY p.name";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("Patient: " + rs.getString("name"));
                System.out.println("Bills: " + rs.getInt("total_bills"));
                System.out.println("Total Due: " + rs.getDouble("total_due"));
                System.out.println("---------------------");
            }

        } catch (Exception e) { e.printStackTrace(); }
    }

    // =============================
    // UC-5.4 Revenue Report
    // =============================
    public void revenueReport(String startDate, String endDate) {

        String sql =
            "SELECT d.name, SUM(b.total_amount) AS revenue " +
            "FROM bills b " +
            "JOIN visits v ON b.visit_id = v.visit_id " +
            "JOIN appointments a ON v.appointment_id = a.appointment_id " +
            "JOIN doctors d ON a.doctor_id = d.doctor_id " +
            "WHERE b.payment_status='PAID' " +
            "AND b.payment_date BETWEEN ? AND ? " +
            "GROUP BY d.name " +
            "HAVING revenue > 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, startDate);
            ps.setString(2, endDate);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Doctor: " + rs.getString("name"));
                System.out.println("Revenue: " + rs.getDouble("revenue"));
                System.out.println("---------------------");
            }

        } catch (Exception e) { e.printStackTrace(); }
    }
}
