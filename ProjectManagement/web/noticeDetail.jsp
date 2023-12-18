<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${notice.title}</title>
  <style>
    #return  {
      color: #007bff;
      text-decoration: none; /* 去除下划线 */
      font-weight: bold; /* 加粗文本 */
    }

    /* 当鼠标悬停在链接上时，修改颜色 */
    #return:hover {
      color: #0056b3;
    }
  </style>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
  String id = request.getParameter("id");
  if (id != null && !id.isEmpty()) {
    NoticeService noticeService = new NoticeServiceImpl();
    Notice notice = noticeService.getById(id);
%>
<div class="container">
  <h2><%=notice.getTitle()%></h2>
  <p><%=notice.getContent()%></p>
</div>
<%
} else {
%>
<div class="container">
  <p>Invalid</p>
</div>
<%
  }
%>
<div class="container">
  <a href="noticeList.jsp" id="return">返回公告栏</a>
</div>
</body>
</html>