<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加作业</title>
    <style>
        .container {
            padding: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            margin-bottom: 5px;
        }

        .btn {
            margin-right: 10px;
        }

        img {
            max-width: 100%;
            height: auto;
            margin-bottom: 15px;
        }
    </style>

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>添加作业</h1>
    <form role="form" action="${pageContext.request.contextPath}/TaskAddServlet" method="post">
        <div class="form-group">
            <label for="content">内容</label>
            <textarea class="form-control" id="content" name="content"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
        <a href="taskList.jsp" class="btn btn-default">取消</a>
    </form>
</div>
</body>
</html>