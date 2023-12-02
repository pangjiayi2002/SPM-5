package Dao.teacher;

import Pojo.Student;
import Pojo.Video;

import java.sql.Connection;
import java.util.List;

public interface VideoDao {
    int add(Connection connection, Video video) throws Exception;

    List<String> getVideoSrcList(Connection connection)throws Exception;
}
