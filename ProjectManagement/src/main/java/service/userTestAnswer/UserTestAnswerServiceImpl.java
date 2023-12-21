package service.userTestAnswer;

import Dao.BaseDao;
import Dao.userTestAnswer.UserTestAnswerDaoImpl;
import Dao.userTestAnswer.UserTestAnswerDao;
import Pojo.StuTest;
import Pojo.UserTestAnswer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserTestAnswerServiceImpl implements UserTestAnswerService {
    private UserTestAnswerDao userTestAnswerDao = new UserTestAnswerDaoImpl();

    @Override
    public boolean add(UserTestAnswer userTestAnswer) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userTestAnswerDao.add(connection, userTestAnswer);
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
    public List<StuTest> getAll(Integer userId) throws Exception {
        Connection connection = null;
        List<StuTest> testList = null;
        try {
            connection = BaseDao.getConnection();
            testList = userTestAnswerDao.getAll(connection,userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return testList;
    }

    @Override
    public List<UserTestAnswer> getAllWithTeacher(Integer testId) throws Exception {
        Connection connection = null;
        List<UserTestAnswer> userTestAnswerList = null;
        try {
            connection = BaseDao.getConnection();
            userTestAnswerList = userTestAnswerDao.getAllWithTeacher(connection,testId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userTestAnswerList;

    }

    @Override
    public UserTestAnswer getById(String id) {
        Connection connection = null;
       UserTestAnswer IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = userTestAnswerDao.getById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }


    @Override
    public boolean modify(UserTestAnswer userTestAnswer) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (userTestAnswerDao.modifyScore(connection, userTestAnswer) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
