package Dao.video;

import Pojo.Video;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public interface VideoDao {
    int add(Connection connection, Video video) throws Exception;
    List<Integer> getVideoIdList(Connection connection)throws Exception;
    List<String> getVideoTitleList(Connection connection)throws Exception;
    List<String> getVideoSrcList(Connection connection)throws Exception;
    List<String> getVideoCoverList(Connection connection) throws Exception;
}
