package com.clinic.connection;


import java.sql.*;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/health_clinic?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

