/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Handles database setup for the Employee Management Application.
 * This file creates the SQLite database and employee table.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:sqlite:employee_management.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                     "employee_id INTEGER PRIMARY KEY, " +
                     "name TEXT NOT NULL, " +
                     "position TEXT NOT NULL, " +
                     "employee_type TEXT NOT NULL, " +
                     "hourly_rate REAL, " +
                     "hours_per_week INTEGER, " +
                     "annual_salary REAL" +
                     ");";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);

        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }
}