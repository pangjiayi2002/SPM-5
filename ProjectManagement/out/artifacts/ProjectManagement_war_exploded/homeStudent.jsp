<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/2
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生端首页</title>
    <style>
        body{
            justify-content: center;
            align-items: center;
        }
        #header{
            justify-content: center;

        }
        input[type="submit"]{
            margin: 20px;
        }
    </style>

</head>
<body>

<div>
    <div id="header" >
        <h1>学生端首页</h1>
        <img src="./images/logo.jpg" alt="none" width="80%%" height="40%">
    </div>
    <br>
    <div>
        <input type="submit" value="教学视频" style="background-color: #3a8dc1;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="作业" style="background-color: #8bc93a;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="测试" style="background-color: aquamarine;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="留言板" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="学习资料库" style="background-color: #5994d6;width:150px;height:100px;font-size: 20px;border: none">
    </div>
</div>
</body>
</html>
