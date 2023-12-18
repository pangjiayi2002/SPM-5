<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="service.task.TaskService" %>
<%@ page import="service.task.TaskServiceImpl" %>
<%@ page import="Pojo.Task" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改作业</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            TaskService taskService = new TaskServiceImpl();
            Task task = taskService.getById(id);
    %>
    <h1>修改作业</h1>
    <form role="form" action="${pageContext.request.contextPath}/TaskModifyServlet" method="post">
        <input type="hidden" name="id" value="<%=task.getId()%>">
        <div class="form-group">
            <label for="content">内容</label>
            <textarea class="form-control" id="content" name="content"><%=task.getContent()%></textarea>
        </div>
        <button type="submit" class="btn btn-primary">更新</button>
        <a href="taskList.jsp" class="btn btn-default">取消</a>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
