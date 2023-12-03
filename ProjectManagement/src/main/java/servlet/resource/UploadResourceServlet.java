package servlet.resource;

import Pojo.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.Resource.ResourceService;
import service.Resource.ResourceServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "UploadResourceServlet", value = "/UploadResourceServlet")
@MultipartConfig
public class UploadResourceServlet extends HttpServlet {
    ResourceService resourceService=new ResourceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> typeMap=new HashMap<>();
        typeMap.put("图书","book");
        typeMap.put("课件","document");
        typeMap.put("案例","case");

        //获取学习资料类型
        String resourceType=request.getParameter("resourceType");
        //获取上传的文件
        Part filePart=request.getPart("file");
        //判断上传的文件是否为空
        if(filePart.getSize()==0){
            //文件为空
            request.setAttribute("message","上传的文件为空，请重新选择！");
            request.getRequestDispatcher("TeacherUploadResource.jsp").forward(request,response);
        }
        else{
            //获取文件名(title)
            String fileName= filePart.getSubmittedFileName();

            //设置上传文件的保存路径
            String uploadPath="D:/github/SPM-5/ProjectManagement/web/"+typeMap.get(resourceType);
            File uploadDir=new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            //拼接文件路径
            String filePath=uploadPath+"/"+fileName;
            filePart.write(filePath);//将文件保存到指定路径
            response.getWriter().write(filePath);//将文件路径返回给前端

            //将文件名，文件src，文件类型添加至数据库
            //存在数据库的src不能用filePath
            String src=typeMap.get(resourceType)+"/"+fileName;
            Resource resource=new Resource();
            resource.setName(fileName);
            resource.setSrc(src);
            resource.setResource_type(resourceType);

            resourceService.add(resource);
            request.setAttribute("message","上传成功！");
            request.getRequestDispatcher("TeacherUploadResource.jsp").forward(request,response);

        }




    }
}