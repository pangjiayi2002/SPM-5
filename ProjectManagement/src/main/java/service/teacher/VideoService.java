package service.teacher;

import Pojo.Student;
import Pojo.Video;

import java.util.List;

public interface VideoService {
    public boolean add(Video video);
    public List<String> getVideoSrcList();
}
