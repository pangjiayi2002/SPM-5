package servlet.teacher;

import Pojo.Video;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.teacher.VideoService;
import service.teacher.VideoServiceImpl;

import java.io.IOException;
import java.util.List;

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
        //上传成功
        if (videoTitle!=null && filename!=null){
            Video video=new Video();
            video.setTitle(videoTitle);
            String src="videos/"+filename;
            System.out.println(src);
            video.setSrc(src);
//            List<String> videoList=videoService.getVideoSrcList();
            videoService.add(video);
            request.getRequestDispatcher("homeTeacher.jsp").forward(request,response);
        }else {//上传失败

        }
    }
}
