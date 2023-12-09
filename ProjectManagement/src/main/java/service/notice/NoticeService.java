package service.notice;

import Pojo.Notice;
import Pojo.Video;

import java.sql.Connection;
import java.util.List;

public interface NoticeService {
    public boolean add(Notice notice);
    List<Notice> getAll()throws Exception;
    public Notice getByTime(String createTime);
    public boolean modify(Notice notice);
    public boolean deleteByTime(String createTime);

}
