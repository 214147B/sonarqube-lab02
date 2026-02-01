package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials removed — read from environment
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    // VULNERABILITY: SQL Injection fixed via PreparedStatement
    public void findUser(String username) throws SQLException {

        String dbUrl = "jdbc:mysql://localhost/db";
        String dbUser = "root";
        String dbPassword = System.getenv("DB_PASSWORD");
        if (dbPassword == null) {
            throw new SQLException("Database password not set in environment variable DB_PASSWORD");
        }

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LOGGER.fine("Found user: " + rs.getString("name"));
                }
            }
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        LOGGER.info("I am never called");
    }
}