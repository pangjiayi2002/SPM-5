<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="service.test.TestServiceImpl" %>
<%@ page import="service.test.TestService" %>
<%@ page import="Pojo.Test" %>
<%@ page import="service.userTestAnswer.UserTestAnswerServiceImpl" %>
<%@ page import="service.userTestAnswer.UserTestAnswerService" %>
<%@ page import="Pojo.UserTestAnswer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .zhezhao {
            position: fixed; /* 或 absolute */
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
            display: none; /* 默认不显示 */
            z-index: 10; /* 确保在其他元素之上 */
        }

        .remove {
            position: fixed; /* 或 absolute */
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%); /* 居中定位 */
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            z-index: 11; /* 比遮罩层高 */
            display: none; /* 默认不显示 */
        }

        /* 样式链接文本的颜色为蓝色 */
        #add {
            color: #007bff;
            text-decoration: none; /* 去除下划线 */
            font-weight: bold; /* 加粗文本 */
        }

        /* 当鼠标悬停在链接上时，修改颜色 */
        #add:hover {
            color: #0056b3;
        }

    </style>

    <meta charset="UTF-8">
    <title>学生作答管理</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%
    String id = request.getParameter("id");
    UserTestAnswerService userTestAnswerService = new UserTestAnswerServiceImpl();
    List<UserTestAnswer> userTestAnswerList = userTestAnswerService.getAllWithTeacher(Integer.valueOf(id));
%>
<div class="container">
    <h1>学生作答管理</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>测试题目</th>
            <th>学生姓名</th>
            <th>分数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="answer" items="<%=userTestAnswerList%>">
            <tr>
                <td>${answer.testName}</td>
                <td>${answer.stuName}</td>
                <td>${answer.score}</td>
                <td>
                    <span><a class="viewNotice" href="answerScoreModify.jsp?id=${answer.id}"><img
                            src="${pageContext.request.contextPath }/images/xiugai.png" alt="批改" title="批改"/></a></span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

