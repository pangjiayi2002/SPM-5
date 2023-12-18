package servlet.userAnswer;

import Pojo.UserAnswer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.userAnswer.UserAnswerService;
import service.userAnswer.UserAnswerServiceImpl;

import java.io.IOException;

@WebServlet(name = "UserAnswerModifyServlet", value = "/UserAnswerModifyServlet")
public class UserAnswerModifyServlet extends HttpServlet {

    private UserAnswerService userAnswerService = new UserAnswerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String score = request.getParameter("score");
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setId(Integer.valueOf(id));
        userAnswer.setScore(Double.valueOf(score));
        userAnswerService.modify(userAnswer);
        request.getRequestDispatcher("taskList.jsp").forward(request, response);
    }
}
