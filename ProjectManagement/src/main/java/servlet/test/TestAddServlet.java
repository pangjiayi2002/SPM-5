package servlet.test;

import Pojo.Test;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.test.TestService;
import service.test.TestServiceImpl;

import java.io.IOException;

@WebServlet(name = "TestAddServlet", value = "/TestAddServlet")
public class TestAddServlet extends HttpServlet {
    private TestService testService = new TestServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        Test test = new Test();
        test.setContent(content);
        testService.add(test);
        request.getRequestDispatcher("testList.jsp").forward(request, response);
    }
}
