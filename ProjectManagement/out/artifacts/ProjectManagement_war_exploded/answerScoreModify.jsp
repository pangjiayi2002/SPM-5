<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="service.task.TaskService" %>
<%@ page import="service.task.TaskServiceImpl" %>
<%@ page import="Pojo.Task" %>
<%@ page import="service.userAnswer.UserAnswerService" %>
<%@ page import="service.userAnswer.UserAnswerServiceImpl" %>
<%@ page import="Pojo.UserAnswer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>批改作业</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            UserAnswerService userAnswerService = new UserAnswerServiceImpl();
            UserAnswer userAnswer = userAnswerService.getById(id);
    %>
    <h1>批改作业</h1>
    <form role="form" action="${pageContext.request.contextPath}/UserAnswerModifyServlet" method="post">
        <input type="hidden" name="id" value="<%=userAnswer.getId()%>">
        <div class="form-group">
            <label for="content">内容</label>
            <textarea class="form-control" id="content" readonly name="content"><%=userAnswer.getTaskName()%></textarea>
        </div>

        <div class="form-group">
            <label for="content">学生回答</label>
            <textarea class="form-control" id="answer" readonly name="content"><%=userAnswer.getAnswer()%></textarea>
        </div>

        <div class="form-group">
            <label for="content">分数</label>
            <input class="form-control" name="score" type="number" min="0" value="<%=userAnswer.getScore()%>">
        </div>

        <button type="submit" class="btn btn-primary">确认</button>
        <a href="taskList.jsp" class="btn btn-default">取消</a>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
