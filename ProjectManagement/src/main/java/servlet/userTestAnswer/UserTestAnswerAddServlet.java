package servlet.userTestAnswer;

import Pojo.Student;
import Pojo.UserTestAnswer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.userTestAnswer.UserTestAnswerService;
import service.userTestAnswer.UserTestAnswerServiceImpl;

import java.io.IOException;

@WebServlet(name = "UserTestAnswerAddServlet", value = "/UserTestAnswerAddServlet")
public class UserTestAnswerAddServlet extends HttpServlet {
    private UserTestAnswerService userTestAnswerService = new UserTestAnswerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testId = request.getParameter("testId");
        String answer = request.getParameter("answer");
        UserTestAnswer userTestAnswer = new UserTestAnswer();
        userTestAnswer.setTestId(Integer.valueOf(testId));
        userTestAnswer.setAnswer(answer);
        int stuId = ((Student) request.getSession().getAttribute("student")).getIdstudent();
        userTestAnswer.setStuId(stuId);
        userTestAnswerService.add(userTestAnswer);
        request.getRequestDispatcher("stuDoTest.jsp").forward(request, response);
    }
}
