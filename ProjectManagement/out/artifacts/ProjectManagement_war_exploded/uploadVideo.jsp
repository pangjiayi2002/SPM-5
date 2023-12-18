<%@ page import="service.video.VideoService" %>
<%@ page import="service.video.VideoServiceImpl" %>
<%@ page import="Pojo.Video" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>上传视频</title>
  <link rel="stylesheet" type="text/css" href="css/video.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f5f5; /* 设置页面背景颜色 */
        }
        .container {
            background-color: #fff; /* 设置容器背景颜色 */
            padding: 20px;
            border-radius: 5px;
            /*box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);*/
        }
        .page-title {
            font-size: 24px;
            margin-bottom: 20px;
        }
        #fanhui {
            margin-top: 10px; /* 调整按钮与标题的垂直间距 */
        }
    </style>
</head>
<body>
<%
    VideoService videoService = new VideoServiceImpl();
    List<Video> list = new ArrayList<>();
    for (int i = 0; i < videoService.getVideoIdList().size(); i++){
        int id = videoService.getVideoIdList().get(i);
        String title = videoService.getVideoTitleList().get(i);
        String cover = videoService.getVideoCoverList().get(i);
        String src = videoService.getVideoSrcList().get(i);
        Video video = new Video(id, title, cover, src);
        list.add(video);
    }
%>
<form action="${pageContext.request.contextPath}/AddVideoServlet" method="post">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1 class="page-title">上传教学视频</h1>
            </div>
            <div class="col-md-4 text-right">
                <a class="btn btn-primary" id="fanhui" href="homeTeacher.jsp">返回首页</a>
            </div>
        </div>
    <h3>已上传视频标题</h3>
    <c:forEach var="video" items="<%=list%>" varStatus="status">
        <ul>
            <li class="tipText">${video.title}</li>
        </ul>
    </c:forEach>
    将要上传的视频标题:
    <textarea name="videoTitle" id="videoTitle"></textarea><br><br>
    <input type="file" class="file" name="fileInput" id="fileInput"><br>
    <input type="submit" value="上传" class="up"/>
    </div>
</form>
</body>
</html>