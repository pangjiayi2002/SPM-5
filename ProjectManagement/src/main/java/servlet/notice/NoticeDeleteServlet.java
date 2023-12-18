package servlet.notice;

import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.notice.NoticeService;
import service.notice.NoticeServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "NoticeDeleteServlet", value = "/NoticeDeleteServlet")
public class NoticeDeleteServlet extends HttpServlet {
    private NoticeService noticeService=new NoticeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        noticeService.deleteById(id);
        request.getRequestDispatcher("noticeList.jsp").forward(request,response);

//        String method = request.getParameter("method");
//        if (method != null && method.equals("delnotice")) {
//            String id= request.getParameter("id");
//            HashMap<String, String> resultMap = new HashMap<String, String>();
//            if (!StringUtils.isNullOrEmpty(id)) {
//                NoticeService noticeService = new NoticeServiceImpl();
//                boolean flag = noticeService.deleteById(id);
//                if (flag) { //删除成功
//                    resultMap.put("delResult", "true");
//                } else { //删除失败
//                    resultMap.put("delResult", "false");
//                }
//            } else {
//                resultMap.put("delResult", "notexist");
//            }
//            System.out.println(resultMap);
//            //把resultMap转换成json对象输出
//            response.setContentType("application/json");
//            PrintWriter outPrintWriter = response.getWriter();
//            outPrintWriter.write(JSONArray.toJSONString(resultMap));
//            outPrintWriter.flush();
//            outPrintWriter.close();
//        }
    }
}
