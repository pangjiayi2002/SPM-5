<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="service.test.TestService" %>
<%@ page import="service.test.TestServiceImpl" %>
<%@ page import="Pojo.Test" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>完成测试</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            TestService testService = new TestServiceImpl();
            Test test = testService.getById(id);
    %>
    <h1>作答</h1>
    交卷时间还剩：<span id="span1" style="color: red">1800</span>秒
    <script language="JavaScript">
        function time() {
            var span1 = document.getElementById("span1");
            var i = span1.innerHTML;
            if(i>0){
                i = i-1;
                span1.innerHTML=i;
            }
        }
        window.setInterval("time()",1000);
    </script>
    <%
        response.setHeader("refresh","1800;url=stuDoTask.jsp");
    %>
    <form role="form" action="${pageContext.request.contextPath}/UserTestAnswerAddServlet" method="post">
        <input type="hidden" name="testId" value="<%=test.getId()%>">
        <div class="form-group">
            <label for="answer">答案</label>
            <textarea class="form-control" id="answer" name="answer"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">确认</button>
        <a href="stuDoest.jsp" class="btn btn-default">取消</a>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
