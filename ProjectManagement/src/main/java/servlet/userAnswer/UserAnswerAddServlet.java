package servlet.userAnswer;

import Pojo.Student;
import Pojo.UserAnswer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.userAnswer.UserAnswerService;
import service.userAnswer.UserAnswerServiceImpl;

import java.io.IOException;

@WebServlet(name = "UserAnswerAddServlet", value = "/UserAnswerAddServlet")
public class UserAnswerAddServlet extends HttpServlet {
    private UserAnswerService userAnswerService = new UserAnswerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        String answer = request.getParameter("answer");
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setTaskId(Integer.valueOf(taskId));
        userAnswer.setAnswer(answer);
        int stuId = ((Student) request.getSession().getAttribute("student")).getIdstudent();
        userAnswer.setStuId(stuId);
        userAnswerService.add(userAnswer);
        request.getRequestDispatcher("stuDoTask.jsp").forward(request, response);
    }
}
