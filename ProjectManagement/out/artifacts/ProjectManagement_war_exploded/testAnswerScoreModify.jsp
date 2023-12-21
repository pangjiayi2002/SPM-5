<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="service.test.TestService" %>
<%@ page import="service.test.TestServiceImpl" %>
<%@ page import="Pojo.Test" %>
<%@ page import="service.userTestAnswer.UserTestAnswerService" %>
<%@ page import="service.userTestAnswer.UserTestAnswerServiceImpl" %>
<%@ page import="Pojo.UserTestAnswer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>批改测试</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            UserTestAnswerService userTestAnswerService = new UserTestAnswerServiceImpl();
            UserTestAnswer userTestAnswer = userTestAnswerService.getById(id);
    %>
    <h1>批改测试</h1>
    <form role="form" action="${pageContext.request.contextPath}/UserTestAnswerModifyServlet" method="post">
        <input type="hidden" name="id" value="<%=userTestAnswer.getId()%>">
        <div class="form-group">
            <label for="content">内容</label>
            <textarea class="form-control" id="content" readonly name="content"><%=userTestAnswer.getTestName()%></textarea>
        </div>

        <div class="form-group">
            <label for="content">学生回答</label>
            <textarea class="form-control" id="answer" readonly name="content"><%=userTestAnswer.getAnswer()%></textarea>
        </div>

        <div class="form-group">
            <label for="content">分数</label>
            <input class="form-control" name="score" type="number" min="0" value="<%=userTestAnswer.getScore()%>">
        </div>

        <button type="submit" class="btn btn-primary">确认</button>
        <a href="testList.jsp" class="btn btn-default">取消</a>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
