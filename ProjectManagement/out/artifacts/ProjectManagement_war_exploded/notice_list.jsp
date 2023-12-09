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
</head>
<body>
<%
    NoticeService noticeService=new NoticeServiceImpl();
    List<Notice> notices = noticeService.getAll();
%>
<div class="container">
    <h1>通知公告</h1>
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
                <a href="notice_detail.jsp"><td>${notice.title}</td></a>
                <td>${notice.createTime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="notice_add.jsp">添加公告</a>
</div>
</body>
</html>
