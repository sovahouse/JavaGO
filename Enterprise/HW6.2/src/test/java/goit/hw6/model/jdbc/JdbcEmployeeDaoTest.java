package goit.hw6.model.jdbc;

import goit.hw6.Main;
import goit.hw6.model.Employee;
import goit.hw6.model.EmployeeDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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