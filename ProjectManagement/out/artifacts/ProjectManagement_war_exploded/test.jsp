<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>项目管理课程教学视频</h1>
<div id="content">
  <%--这里用jstl从数据库读？--%>
  <%--点击数据库跳转播放视频--%>
  <ul>
    <div class="index-vedio">
      <li>
        <img src="videoImages/1.jpg" onclick="playVideo('videos/1.mp4')">
      </li>
    </div>
    <li class="tipText">标题</li>
  </ul>
</div>
<div id="video-container"></div>
<script>
  function playVideo(videoUrl) {
    var container = document.getElementById("video-container");
    container.innerHTML = `<video id="video-player" width="100%" height="100%" controls autoplay>
                                        <source src="${videoUrl}" type="video/mp4">
                                   </video>`;
  }
</script>
</body>
</html>