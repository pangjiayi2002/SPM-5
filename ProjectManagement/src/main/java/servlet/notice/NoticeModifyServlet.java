package servlet.notice;

import Pojo.Notice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.notice.NoticeService;
import service.notice.NoticeServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "NoticeModifyServlet", value = "/NoticeModifyServlet")
public class NoticeModifyServlet extends HttpServlet {
    private NoticeService noticeService=new NoticeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String createTime=request.getParameter("createTime");
        Notice notice=new Notice(title,content,createTime);
        System.out.println(notice.toString());
        noticeService.modify(notice);
        request.getRequestDispatcher("noticeList.jsp").forward(request,response);
    }
}
