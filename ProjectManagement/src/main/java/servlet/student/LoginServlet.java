package servlet.student;

import Pojo.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Student.StudentService;
import service.Student.StudentServiceImpl;

import java.io.IOException;

@WebServlet(name = "servlet.student.LoginServlet", value = "/servlet.student.LoginServlet")
public class LoginServlet extends HttpServlet {
    StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String userType=request.getParameter("userType");
        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");
        //调用service方法，进行用户匹配
        if(userType!=null && userType.equals("teacher")){
            if(userCode.equals("admin") && userPassword.equals("admin")){
                //教师端成功登录
                //页面重定向
                response.sendRedirect("");
            }else{
                //页面转发（log.jsp）带出提示信息
                request.setAttribute("error","用户名或密码不正确");
                request.getRequestDispatcher("log.jsp").forward(request,response);
            }
        }else{
            //学生端
            Student student=studentService.login(userCode,userPassword);
            if(null!=student){//登录成功
                //放入session
                request.getSession().setAttribute("student",student);
                //页面重定向
                response.sendRedirect("");
            }else{
                //页面转发（log.jsp）带着提示信息转发
                request.setAttribute("error","用户名或密码不正确");
                request.getRequestDispatcher("log.jsp").forward(request,response);
            }
        }

    }
}
