package service.teacher;

import Dao.BaseDao;
import Dao.teacher.VideoDao;
import Dao.teacher.VideoDaoImpl;
import Pojo.Video;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VideoServiceImpl implements VideoService{
    private VideoDao videoDao=new VideoDaoImpl();

    @Override
    public boolean add(Video video) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = videoDao.add(connection, video);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public List<String> getVideoSrcList() {
        Connection connection = null;
        List<String> videoList = null;
        try {
            connection = BaseDao.getConnection();
            videoList = videoDao.getVideoSrcList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return videoList;
    }
}
