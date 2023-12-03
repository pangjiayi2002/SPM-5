<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/3
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师端上传学习资料</title>
</head>
<body>
    <div>
        <h1>上传学习资料</h1>
        <p>${requestScope.message}</p>
    </div>
<div>
    <form action="${pageContext.request.contextPath }/UploadResourceServlet" method="post" enctype="multipart/form-data">
        选择上传的学习资料类型:<select name="resourceType">
        <option value="图书">图书</option>
        <option value="课件">课件</option>
        <option value="案例">案例</option>
    </select>
        <br>
        选择上传的学习资料:<input type="file" name="file" size="40">
        <input type="submit" name="上传">
    </form>

</div>
</body>
</html>
