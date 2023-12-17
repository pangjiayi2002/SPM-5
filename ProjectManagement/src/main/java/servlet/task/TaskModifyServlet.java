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

@WebServlet(name = "TaskModifyServlet", value = "/TaskModifyServlet")
public class TaskModifyServlet extends HttpServlet {
    private TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String content = request.getParameter("content");
        Task task = new Task(Integer.valueOf(id), content);
        taskService.modify(task);
        request.getRequestDispatcher("taskList.jsp").forward(request, response);
    }
}
