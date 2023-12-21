package servlet.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.test.TestService;
import service.test.TestServiceImpl;

import java.io.IOException;

@WebServlet(name = "TestDeleteServlet", value = "/TestDeleteServlet")
public class TestDeleteServlet extends HttpServlet {
    private TestService testService = new TestServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        testService.deleteById(id);
        request.getRequestDispatcher("testList.jsp").forward(request,response);
    }
}
