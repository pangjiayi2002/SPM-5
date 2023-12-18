package service.userAnswer;

import Dao.BaseDao;
import Dao.userAnswer.UseAnswerDaoImpl;
import Dao.userAnswer.UserAnswerDao;
import Pojo.StuTask;
import Pojo.UserAnswer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserAnswerServiceImpl implements UserAnswerService {
    private UserAnswerDao userAnswerDao = new UseAnswerDaoImpl();

    @Override
    public boolean add(UserAnswer userAnswer) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = userAnswerDao.add(connection, userAnswer);
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
    public List<StuTask> getAll(Integer userId) throws Exception {
        Connection connection = null;
        List<StuTask> taskList = null;
        try {
            connection = BaseDao.getConnection();
            taskList = userAnswerDao.getAll(connection,userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return taskList;
    }

    @Override
    public List<UserAnswer> getAllWithTeacher(Integer taskId) throws Exception {
        Connection connection = null;
        List<UserAnswer> userAnswerList = null;
        try {
            connection = BaseDao.getConnection();
            userAnswerList = userAnswerDao.getAllWithTeacher(connection,taskId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return userAnswerList;

    }

    @Override
    public UserAnswer getById(String id) {
        Connection connection = null;
        UserAnswer IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = userAnswerDao.getById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }


    @Override
    public boolean modify(UserAnswer userAnswer) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (userAnswerDao.modifyScore(connection, userAnswer) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
