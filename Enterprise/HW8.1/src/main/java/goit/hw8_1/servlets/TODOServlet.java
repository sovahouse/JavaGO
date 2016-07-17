package goit.hw8_1.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TODOServlet extends HttpServlet{

    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        task.setName(request.getParameter("name"));
        task.setCategory(request.getParameter("category"));
        tasks.add(task);
        request.setAttribute("tasks", tasks);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ToDo.jsp");
        rd.forward(request, response);

        /*PrintWriter out = response.getWriter();

        for(Task t: tasks) {
            out.println(t.toString());
        }*/
    }
}
