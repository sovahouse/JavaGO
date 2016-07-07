package goit.hw6.model.jdbc;

import goit.hw6.model.Employee;
import goit.hw6.model.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcEmployeeDao implements EmployeeDao {

    private DataSource dataSource;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee load(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
               return createEmployee(resultSet);
            } else {
                throw new RuntimeException("Cannot find goit.hw6.model.Employee with id" + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException(e);
        }
    }

    public void addEmployee() {

    }
    public void deleteEmployee() {
    }
    public List<Employee> findByName(String name) {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE FIRST_NAME = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Employee with name: " + name);
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
                Employee employee = createEmployee(resultSet);
                result.add(employee);
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
