<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传视频</title>
  <link rel="stylesheet" type="text/css" href="css/video.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/AddVideoServlet" method="post">
    <h1>视频上传</h1>
    视频标题:
    <textarea name="videoTitle" id="videoTitle"></textarea><br><br>
    <input type="file" class="file" name="fileInput" id="fileInput"><br>
    <input type="submit" value="上传" class="up"/>
</form>
</body>
</html>