<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>修改留言</title>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <%
    String noticeTime = request.getParameter("noticeTime");
    if (noticeTime != null && !noticeTime.isEmpty()) {
      NoticeService noticeService = new NoticeServiceImpl();
      Notice notice = noticeService.getByTime(noticeTime);
  %>
  <h1>修改留言</h1>
  <form role="form" action="${pageContext.request.contextPath}/NoticeModifyServlet" method="post">
    <input type="hidden" name="createTime" value="<%=notice.getCreateTime()%>">
    <div class="form-group">
      <label for="title">标题</label>
      <input type="text" class="form-control" id="title" name="title" value="<%=notice.getTitle()%>">
    </div>
    <div class="form-group">
      <label for="content">内容</label>
      <textarea class="form-control" id="content" name="content"><%=notice.getContent()%></textarea>
    </div>
    <button type="submit" class="btn btn-primary">更新</button>
    <a href="noticeList.jsp" class="btn btn-default">取消</a>
  </form>
  <%
  }
  %>
</div>
</body>
</html>
