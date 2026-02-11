package com.clinic.main;

import java.sql.Connection;
import com.clinic.connection.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Connection conn = DBConnection.getConnection();
            System.out.println("Database Connected Successfully!");
            conn.close();
        } catch (Exception e) {
            System.out.println(" Connection Failed!");
            e.printStackTrace();
        }
    }
}

