
package service.test;

import Dao.BaseDao;
import Dao.test.TestDao;
import Dao.test.TestDaoImpl;
import Pojo.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestServiceImpl implements TestService {
    private TestDao TestDao = new TestDaoImpl();

    @Override
    public boolean add(Test test) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = TestDao.add(connection, test);
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
    public List<Test> getAll() throws Exception {
        Connection connection = null;
        List<Test> TestList = null;
        try {
            connection = BaseDao.getConnection();
            TestList = TestDao.getAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return TestList;
    }

    @Override
    public Test getById(String id) {
        Connection connection = null;
        Test IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = TestDao.getById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }

    @Override
    public boolean modify(Test test) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (TestDao.modify(connection, test) > 0)
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
            if (TestDao.deleteById(connection, id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
