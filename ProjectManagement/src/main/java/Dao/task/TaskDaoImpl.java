package Dao.task;

import Dao.BaseDao;
import Pojo.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public int add(Connection connection, Task task) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.task (content) values(?)";
            Object[] params = {task.getContent()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public List<Task> getAll(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Task> List = new ArrayList<>();
        if (null != connection) {
            List<Object> taskList = new ArrayList<>();
            String sql = "select * from spm.task";
            Object[] params = taskList.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Task task = new Task(id, content);
                List.add(task);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public Task getById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Task task = null;
        if (null != connection) {
            List<Object> list = new ArrayList<>();
            String sql = "select * from spm.task";
            Object[] params = list.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                if (id.equals(rs.getString("id"))) {
                    String content = rs.getString("content");
                    task = new Task(Integer.valueOf(id), content);
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return task;
    }

    @Override
    public int modify(Connection connection, Task task) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update spm.task set content=? where id = ? ";
            Object[] params = {task.getContent(), task.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public int deleteById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if (null != connection) {
            String sql = "delete from spm.task where id=?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }
}