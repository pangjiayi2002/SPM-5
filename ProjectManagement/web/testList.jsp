<%@ page import="service.notice.NoticeService" %>
<%@ page import="service.notice.NoticeServiceImpl" %>
<%@ page import="Pojo.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="service.test.TestServiceImpl" %>
<%@ page import="service.test.TestService" %>
<%@ page import="Pojo.Test" %>
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
    <title>作业管理</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <%
    TestService testService=new TestServiceImpl();
    List<Test> tests = testService.getAll();
%>
<div class="container">
    <h1>作业管理</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>作业题目</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="test" items="<%=tests%>">
            <tr>
                <td>${test.id}</td>
                <td>${test.content}</td>
                <td>
                    <span><a class="viewNotice" href="userTestAnswerList.jsp?id=${test.id}"><img
                            src="${pageContext.request.contextPath }/images/read.png" alt="批改作业" title="批改作业"/></a></span>
                    <span><a class="modifyNotice" href="testModify.jsp?id=${test.id}"><img
                            src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改"
                            title="修改"/></a></span>
                    <span><a class="deleteNotice"
                             href="${pageContext.request.contextPath}/TestDeleteServlet?id=${test.id}"
                             title=${test.content}><img src="${pageContext.request.contextPath}/images/schu.png"
                                                        alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="testAdd.jsp" id="add">添加作业</a>
</div>

