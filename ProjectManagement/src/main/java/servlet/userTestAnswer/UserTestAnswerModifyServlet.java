package servlet.userTestAnswer;

import Pojo.UserTestAnswer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.userTestAnswer.UserTestAnswerService;
import service.userTestAnswer.UserTestAnswerServiceImpl;

import java.io.IOException;

@WebServlet(name = "UserTestAnswerModifyServlet", value = "/UserTestAnswerModifyServlet")
public class UserTestAnswerModifyServlet extends HttpServlet {

    private UserTestAnswerService userTestAnswerService = new UserTestAnswerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String score = request.getParameter("score");
        UserTestAnswer userTestAnswer = new UserTestAnswer();
        userTestAnswer.setId(Integer.valueOf(id));
        userTestAnswer.setScore(Double.valueOf(score));
        userTestAnswerService.modify(userTestAnswer);
        request.getRequestDispatcher("testList.jsp").forward(request, response);
    }
}
