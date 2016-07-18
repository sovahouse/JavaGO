package goit.hw8_1.servlets;

import goit.hw8_1.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TODOServlet extends HttpServlet{

    private Map<Integer, Task> tasks = new HashMap<>();
    private int id = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submit").equals("Add Task")) {
            Task task = new Task();
            task.setId(++id);
            task.setName(request.getParameter("name"));
            task.setCategory(request.getParameter("category"));

            tasks.put(id, task);

        } else if(request.getParameter("submit").equals("Update") && request.getParameter("complete") != null) {

            String[] checkboxes = request.getParameterValues("complete");

            for (String s: checkboxes) {
                int checkboxId = Integer.parseInt(s);
                tasks.remove(checkboxId);
            }
        }

        request.setAttribute("tasks", tasks);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ToDo.jsp");
        rd.forward(request, response);
    }
}
