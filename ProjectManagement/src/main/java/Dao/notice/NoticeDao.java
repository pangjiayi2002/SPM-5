package Dao.notice;

import Pojo.Notice;
import Pojo.Video;

import java.sql.Connection;
import java.util.List;

public interface NoticeDao {
    //添加公告
    int add(Connection connection, Notice notice) throws Exception;
    List<Notice> getAll(Connection connection)throws Exception;
    Notice getById(Connection connection,String id)throws Exception;
    //修改公告
    int modify(Connection connection, Notice notice) throws Exception;
    //删除公告
    public int deleteById(Connection connection, String id)throws Exception;

}
