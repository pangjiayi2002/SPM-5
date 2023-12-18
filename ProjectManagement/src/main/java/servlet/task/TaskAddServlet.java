package servlet.task;

import Pojo.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.task.TaskService;
import service.task.TaskServiceImpl;

import java.io.IOException;

@WebServlet(name = "TaskAddServlet", value = "/TaskAddServlet")
public class TaskAddServlet extends HttpServlet {
    private TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        Task task = new Task();
        task.setContent(content);
        taskService.add(task);
        request.getRequestDispatcher("taskList.jsp").forward(request, response);
    }
}
