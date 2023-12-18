package service.task;

import Dao.BaseDao;
import Dao.task.TaskDao;
import Dao.task.TaskDaoImpl;
import Pojo.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao = new TaskDaoImpl();

    @Override
    public boolean add(Task task) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = taskDao.add(connection, task);
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
    public List<Task> getAll() throws Exception {
        Connection connection = null;
        List<Task> taskList = null;
        try {
            connection = BaseDao.getConnection();
            taskList = taskDao.getAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return taskList;
    }

    @Override
    public Task getById(String id) {
        Connection connection = null;
        Task IdList = null;
        try {
            connection = BaseDao.getConnection();
            IdList = taskDao.getById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return IdList;
    }

    @Override
    public boolean modify(Task task) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (taskDao.modify(connection, task) > 0)
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
            if (taskDao.deleteById(connection, id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
