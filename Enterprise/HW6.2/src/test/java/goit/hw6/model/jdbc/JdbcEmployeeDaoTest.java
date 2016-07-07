package goit.hw6.model.jdbc;

import goit.hw6.model.Employee;
import org.junit.Test;

import java.util.List;

public class JdbcEmployeeDaoTest {

    private static JdbcEmployeeDao jdbcEmployeeDao = new JdbcEmployeeDao();

    @Test
    public void addEmployee() throws Exception {

    }

    @Test
    public void deleteEmployee() throws Exception {

    }

    @Test
    public void findByName() throws Exception {
        String name = "Robert";
        List<Employee> result = jdbcEmployeeDao.findByName(name);
        System.out.printf("");
        //assertEquals(name, result.getFirstName());
    }

}