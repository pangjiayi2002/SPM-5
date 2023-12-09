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
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
  String noticeTime = request.getParameter("noticeTime");
  if (noticeTime != null && !noticeTime.isEmpty()) {
    NoticeService noticeService = new NoticeServiceImpl();
    Notice notice = noticeService.getByTime(noticeTime);
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
  <a href="noticeList.jsp">返回公告栏</a>
</div>
</body>
</html>