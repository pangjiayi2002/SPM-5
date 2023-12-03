package servlet;

import Pojo.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Resource.ResourceService;
import service.Resource.ResourceServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudyResourceServlet", value = "/StudyResourceServlet")
public class StudyResourceServlet extends HttpServlet {
    private ResourceService resourceService=new ResourceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");//获取需要的学习资料的类型
        ArrayList<Resource> ResourceList= resourceService.getResourceListByType(type);
        //将类型和列表存在session对象中
        HttpSession session= request.getSession();
        session.setAttribute("type",type);
        session.setAttribute("ResourceList",ResourceList);
        request.getRequestDispatcher("resourceDisplay.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}