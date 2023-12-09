package servlet.notice;

import Pojo.Notice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.notice.NoticeService;
import service.notice.NoticeServiceImpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

@WebServlet(name = "NoticeAddServlet", value = "/NoticeAddServlet")
public class NoticeAddServlet extends HttpServlet {
    private NoticeService noticeService=new NoticeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime currentTime = LocalDateTime.now();
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化当前时间
        String formattedTime = currentTime.format(formatter);
        Notice notice=new Notice(title,content,formattedTime);
        noticeService.add(notice);
        request.getRequestDispatcher("noticeList.jsp").forward(request,response);
    }
}
