import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        loadDriver();

        LOGGER.info("Connecting to DB");
        String url = "jdbc:postgresql://localhost:2222/Restaurant";
        String user = "User";
        String password = "111";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            LOGGER.info("Successfully connected to DB");

            String sql = "SELECT * FROM EMPLOYEE";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("ID"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setBirthDate(resultSet.getDate("BIRTH_DATE").toLocalDate());
                employee.setPhone(resultSet.getString("PHONE"));
                employee.setPosition(resultSet.getString("POSITION"));
                employee.setSalary(resultSet.getDouble("SALARY"));
                System.out.println(employee.toString());
            }


        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to DB " + url, e);
        }



    }

    private static void loadDriver() {
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
