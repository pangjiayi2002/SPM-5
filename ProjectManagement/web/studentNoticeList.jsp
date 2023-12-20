<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>通知公告</title>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    body {
      background-color: #f5f5f5; /* 设置页面背景颜色 */
    }
    .container {
      background-color: #fff; /* 设置容器背景颜色 */
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .page-title {
      font-size: 24px;
      margin-bottom: 20px;
    }
    #fanhui {
      margin-top: 10px; /* 调整按钮与标题的垂直间距 */
    }
  </style>
</head>
<body>
<%
  NoticeService noticeService=new NoticeServiceImpl();
  List<Notice> notices = noticeService.getAll();
%>
<div class="container">
  <div class="row">
    <div class="col-md-8">
      <h1 class="page-title">通知公告</h1>
    </div>
    <div class="col-md-4 text-right">
      <a class="btn btn-primary" id="fanhui" href="homeStudent.jsp">返回首页</a>

    </div>
  </div>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>标题</th>
      <th>创建时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="notice" items="<%=notices%>">
      <tr>
        <td>${notice.title}</td>
        <td>${notice.createTime}</td>
        <td>
          <span><a class="view" href="noticeDetail.jsp?id=${notice.id}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
          </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
