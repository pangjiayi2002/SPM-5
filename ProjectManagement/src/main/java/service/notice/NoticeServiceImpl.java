package service.notice;

import Dao.BaseDao;
import Dao.notice.NoticeDao;
import Dao.notice.NoticeDaoImpl;
import Pojo.Notice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NoticeServiceImpl implements NoticeService{
    private NoticeDao noticeDao=new NoticeDaoImpl();

    @Override
    public boolean add(Notice notice) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = noticeDao.add(connection, notice);
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
    public List<Notice> getAll() throws Exception {
        Connection connection = null;
        List<Notice> NoticeList = null;
        try {
            connection = BaseDao.getConnection();
            NoticeList = noticeDao.getAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return NoticeList;
    }

    @Override
    public Notice getById(String id) {
        Connection connection = null;
        Notice IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = noticeDao.getById(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }

    @Override
    public boolean modify(Notice notice) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (noticeDao.modify(connection, notice) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean deleteById(String id) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (noticeDao.deleteById(connection,id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
