<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<form action="" method="post">
    <div align="center">
        <span style="font-size: 20px">在线学习网站</span><hr>
<%--        <h1 style="color: red"><%=msg%></h1>--%>
        <span style="font-size: 20px">用户名:</span>
        <input type="text" name="speaker"><br><br>
        <span style="font-size: 20px">密码:</span>
        <input type="text" name="speaker"><br><br>
        <input type="submit" value="登录" style="font-size: 20px">
        <input type="button" value="注册" style="font-size: 20px" onclick="parent.location.href='/register.jsp'"/>
    </div>
</form>
</body>
</html>
