<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师端首页</title>
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
        <h1>教师端首页</h1>
        <img src="./images/logo.jpg" alt="none" width="80%%" height="40%">
    </div>
    <br>
    <div>
        <input type="submit" value="上传教学视频" style="background-color: #3a8dc1;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='uploadVideo.jsp'">
        <input type="submit" value="作业管理" style="background-color: #8bc93a;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="测试管理" style="background-color: aquamarine;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="留言板" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="学习资料库" style="background-color: #5994d6;width:150px;height:100px;font-size: 20px;border: none">
        <input type="submit" value="上传题库" style="background-color: lightcoral;width:150px;height:100px;font-size: 20px;border: none">
    </div>
</div>
</body>
</html>
