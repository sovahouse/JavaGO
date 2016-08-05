package goit.hw7.model.jdbc;

import goit.hw7.model.Employee;
import goit.hw7.model.DaoInterfaces.EmployeeDao;
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
    public void addEmployee(Employee employee) { //TODO: add employee collector from web input for putting into this method + testing

        String query = "INSERT INTO EMPLOYEE (ID, surname, name, BIRTH_DATE, PHONE, POSITION, SALARY) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getFirstName());
            statement.setDate(4, Date.valueOf(employee.getBirthDate()));
            statement.setString(5, employee.getPhone());
            statement.setString(6, employee.getPosition());
            statement.setDouble(7, employee.getSalary());

            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot add new employee" + employee.toString());
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteEmployeeById(int id) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find Employee with id: " + id);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Employee> findByName(String name) {
        List<Employee> result = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE name = ?")) {
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

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Employee getById(int id) {

        Employee employee = new Employee();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee = createEmployee(resultSet);
            }

            return employee;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB ", e);
            throw new RuntimeException("Cannot find employee with id: " + id);
        }

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
