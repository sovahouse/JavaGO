package goit.hw6.model.jdbc;

import goit.hw6.model.Employee;
import goit.hw6.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcEmployeeDao implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    private final String url = "jdbc:postgresql://localhost:2222/Restaurant";
    private final String user = "User";
    private final String password = "111";

    public JdbcEmployeeDao() {
        loadDriver();
    }

    @Override
    public Employee load(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return createEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find goit.hw6.model.Employee with id" + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB " + url, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB " + url, e);
            throw new RuntimeException(e);
        }

        return result;

    }

    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setBirthDate(resultSet.getDate("BIRTH_DATE").toLocalDate());
        employee.setPhone(resultSet.getString("PHONE"));
        employee.setPosition(resultSet.getString("POSITION"));
        employee.setSalary(resultSet.getDouble("SALARY"));
        return employee;
    }

    private void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }

}
