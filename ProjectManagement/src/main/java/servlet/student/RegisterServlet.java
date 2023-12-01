package servlet.student;

import Pojo.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Student.StudentService;
import service.Student.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> studnameList=studentService.getStuNameList();
        String studentName=request.getParameter("userCode");
        String studentPassword=request.getParameter("userPassword");
        Student student=new Student();
        student.setStuname(studentName);
        student.setPassword(studentPassword);
        if(studnameList.contains(studentName)){
            request.setAttribute("error", "用户名重复");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else {
            studentService.add(student);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
