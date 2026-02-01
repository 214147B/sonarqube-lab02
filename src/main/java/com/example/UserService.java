package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level; 

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

        String query = "SELECT name FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LOGGER.log(Level.FINE, "Found user: {0}", rs.getString("name"));
                }
            }
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("I am never called");
        }
    }
}