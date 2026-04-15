/**
 * Name: Maurice Ruffin
 * Date: 04/15/2026
 * Purpose: Handles CRUD operations for employee records in the SQLite database.
 * This file demonstrates Create, Read, Update, and Delete operations.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void insertSampleData() {
        if (!getAllEmployees().isEmpty()) {
            return;
        }

        addEmployee(new HourlyEmployee(101, "Jordan Miles", "Support Specialist", 22.50, 40));
        addEmployee(new SalariedEmployee(102, "Alicia Carter", "Project Manager", 72000.00));
        addEmployee(new HourlyEmployee(103, "Brian Woods", "Lab Assistant", 18.75, 35));
        addEmployee(new SalariedEmployee(104, "Tiana Brooks", "Systems Analyst", 68000.00));
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (employee_id, name, position, employee_type, hourly_rate, hours_per_week, annual_salary) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getPosition());
            statement.setString(4, employee.getEmployeeType());

            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                statement.setDouble(5, hourlyEmployee.getHourlyRate());
                statement.setInt(6, hourlyEmployee.getHoursPerWeek());
                statement.setNull(7, java.sql.Types.REAL);
            } else if (employee instanceof SalariedEmployee) {
                SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
                statement.setNull(5, java.sql.Types.REAL);
                statement.setNull(6, java.sql.Types.INTEGER);
                statement.setDouble(7, salariedEmployee.getAnnualSalary());
            }

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Add employee error: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY employee_id";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                employees.add(buildEmployeeFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            System.out.println("Get all employees error: " + e.getMessage());
        }

        return employees;
    }

    public Employee getEmployeeById(int employeeId) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildEmployeeFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            System.out.println("Get employee by ID error: " + e.getMessage());
        }

        return null;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, position = ?, employee_type = ?, hourly_rate = ?, hours_per_week = ?, annual_salary = ? " +
                     "WHERE employee_id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setString(3, employee.getEmployeeType());

            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                statement.setDouble(4, hourlyEmployee.getHourlyRate());
                statement.setInt(5, hourlyEmployee.getHoursPerWeek());
                statement.setNull(6, java.sql.Types.REAL);
            } else if (employee instanceof SalariedEmployee) {
                SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
                statement.setNull(4, java.sql.Types.REAL);
                statement.setNull(5, java.sql.Types.INTEGER);
                statement.setDouble(6, salariedEmployee.getAnnualSalary());
            }

            statement.setInt(7, employee.getEmployeeId());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update employee error: " + e.getMessage());
        }
    }

    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete employee error: " + e.getMessage());
        }
    }

    /*
     * Private helper method is used only inside this class.
     * This is an example of using access specifiers appropriately.
     */
    private Employee buildEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("employee_id");
        String name = resultSet.getString("name");
        String position = resultSet.getString("position");
        String type = resultSet.getString("employee_type");

        if (type.equalsIgnoreCase("Hourly")) {
            double hourlyRate = resultSet.getDouble("hourly_rate");
            int hoursPerWeek = resultSet.getInt("hours_per_week");
            return new HourlyEmployee(id, name, position, hourlyRate, hoursPerWeek);
        } else {
            double annualSalary = resultSet.getDouble("annual_salary");
            return new SalariedEmployee(id, name, position, annualSalary);
        }
    }
}