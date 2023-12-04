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
    <h1>视频上传</h1>
<%--    感觉得显示一下有哪些视频已经上传--%>
    <h3>已上传视频标题</h3>
    <c:forEach var="video" items="<%=list%>" varStatus="status">
        <ul>
            <li class="tipText">${video.title}</li>
        </ul>
    </c:forEach>
    视频标题:
    <textarea name="videoTitle" id="videoTitle"></textarea><br><br>
    <input type="file" class="file" name="fileInput" id="fileInput"><br>
    <input type="submit" value="上传" class="up"/>
</form>
</body>
</html>