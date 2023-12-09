<%@ page import="service.video.VideoService" %>
<%@ page import="service.video.VideoServiceImpl" %>
<%@ page import="Pojo.Video" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>视频播放</title>
    <link rel="stylesheet" href="css/videoImages.css">
    <style>
        #video-container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 640px;
            height: 360px;
            overflow: hidden;
            border: none;
        }
    </style>
</head>
<body>
<div id="title">
    <h1>项目管理课程教学视频</h1>

    <video src="XXXXX" controls autoplay></video>
</div>
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
<div id="content">
    <c:forEach var="video" items="<%=list%>" varStatus="status">
        <ul>
            <div class="index-vedio">
                <li>
                    <img src="${video.cover}" onclick="playVideo('${video.src}')">
                </li>
                <li class="tipText">${video.title}</li>
            </div>
        </ul>
    </c:forEach>
</div>
<div id="video-container"></div>
<script>
    function playVideo(videoUrl) {
        var container = document.getElementById("video-container");
        container.innerHTML = '<video id="video-player" width="100%" height="100%" controls autoplay>' +
            '<source src="' + videoUrl + '" type="video/mp4"></video>';
    }
</script>
<br><br>
<a href="homeStudent.jsp">返回学生首页</a>
</body>
</html>

