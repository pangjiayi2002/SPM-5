<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/2
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>导航栏示例</title>
    <style>
        .nav {
            margin: 0;
            padding: 0;
            list-style: none;
        }
        .nav li {
            display: inline-block;
            position: relative;
        }
        .nav li a {
            display: block;
            padding: 10px;
            text-decoration: none;
        }
        .nav li ul {
            position: absolute;
            top: 100%;
            left: 0;
            display: none;
            padding: 0;
            list-style: none;
            background-color: #fff;
            border: 1px solid #ccc;
        }
        .nav li:hover ul {
            display: block;
        }
        .nav li ul li {
            float: none;
            position: relative;
        }
        .nav li ul li a {
            padding: 10px;
        }
    </style>
</head>
<body>
<ul class="nav">
    <li><a href="#">图书</a>
        <ul>
            <li><a href="book1.html">图书1</a></li>
            <li><a href="book2.html">图书2</a></li>
            <li><a href="book3.html">图书3</a></li>
        </ul>
    </li>
    <li><a href="#">课件</a>
        <ul>
            <li><a href="course1.html">课程1</a></li>
            <li><a href="course2.html">课程2</a></li>
            <li><a href="course3.html">课程3</a></li>
        </ul>
    </li>
    <li><a href="#">案例</a>
        <ul>
            <li><a href="case1.html">案例1</a></li>
            <li><a href="case2.html">案例2</a></li>
            <li><a href="case3.html">案例3</a></li>
        </ul>
    </li>
</ul>
</body>
</html>