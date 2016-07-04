package goit.hw6;

import goit.hw6.model.EmployeeDao;
import goit.hw6.model.jdbc.JdbcEmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EmployeeDao jdbcEmployeeDao = new JdbcEmployeeDao();
        jdbcEmployeeDao.getAll().forEach(System.out::println);

        System.out.println("Employee with id 2");
        System.out.println(jdbcEmployeeDao.load(2));
    }


}
