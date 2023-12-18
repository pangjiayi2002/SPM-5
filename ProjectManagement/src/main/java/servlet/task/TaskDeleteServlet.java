package servlet.task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.task.TaskService;
import service.task.TaskServiceImpl;

import java.io.IOException;

@WebServlet(name = "TaskDeleteServlet", value = "/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
    private TaskService taskService = new TaskServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        taskService.deleteById(id);
        request.getRequestDispatcher("taskList.jsp").forward(request,response);
    }
}
