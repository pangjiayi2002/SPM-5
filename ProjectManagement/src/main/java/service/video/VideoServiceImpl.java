package service.video;

import Dao.BaseDao;
import Dao.video.VideoDao;
import Dao.video.VideoDaoImpl;
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
    public List<Integer> getVideoIdList() {
        Connection connection = null;
        List<Integer> IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = videoDao.getVideoIdList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }

    @Override
    public List<String> getVideoTitleList() {
        Connection connection = null;
        List<String> TitleList = null;
        try {
            connection = BaseDao.getConnection();
            TitleList = videoDao.getVideoTitleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return TitleList;
    }

    @Override
    public List<String> getVideoCoverList() {
        Connection connection = null;
        List<String> coverList = null;
        try {
            connection = BaseDao.getConnection();
            coverList = videoDao.getVideoCoverList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return coverList;
    }

    @Override
    public List<String> getVideoSrcList() {
        Connection connection = null;
        List<String> srcList = null;
        try {
            connection = BaseDao.getConnection();
            srcList = videoDao.getVideoSrcList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return srcList;
    }
}
