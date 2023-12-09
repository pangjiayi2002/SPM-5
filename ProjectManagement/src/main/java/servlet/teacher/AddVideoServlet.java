package servlet.teacher;

import Pojo.Video;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.video.VideoService;
import service.video.VideoServiceImpl;

import java.io.IOException;

@WebServlet(name = "AddVideoServlet", value = "/AddVideoServlet")
public class AddVideoServlet extends HttpServlet {
    VideoService videoService=new VideoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoTitle=request.getParameter("videoTitle");
        String filename=request.getParameter("fileInput");
        //上传成功，感觉得搞个提示，还没写提示
        if (videoTitle!=null && filename!=null){
            Video video=new Video();
            video.setTitle(videoTitle);
            String cover;
            if (filename.equals("1.mp4")){
                cover="videoImages/1.jpg";
            }else if (filename.equals("2.mp4")){
                cover="videoImages/2.jpg";
            }else if (filename.equals("3.mp4")){
                cover="videoImages/3.jpg";
            }else if (filename.equals("4.mp4")){
                cover="videoImages/4.jpg";
            }else if (filename.equals("5.mp4")){
                cover="videoImages/5.jpg";
            }else {
                cover="videoImages/6.jpg";
            }
            video.setCover(cover);
            String src="videos/"+filename;
//            System.out.println(src);
            video.setSrc(src);
//            List<String> videoList=videoService.getVideoSrcList();
            videoService.add(video);
            request.getRequestDispatcher("homeTeacher.jsp").forward(request,response);
        }else {//上传失败

        }
    }
}
