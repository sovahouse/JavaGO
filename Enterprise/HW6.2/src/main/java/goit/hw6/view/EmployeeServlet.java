package goit.hw6.view;

import goit.hw6.controllers.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {

    private EmployeeController employeeController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        employeeController = context.getBean(EmployeeController.class);
        out.println(employeeController.getById(1).toString());

    }

}
