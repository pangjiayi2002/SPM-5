package Dao.test;

import Dao.BaseDao;
import Pojo.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl implements TestDao {

    @Override
    public int add(Connection connection, Test test) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.test (content) values(?)";
            Object[] params = {test.getContent()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public List<Test> getAll(Connection connection) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Test> List = new ArrayList<>();
        if (null != connection) {
            List<Object> testList = new ArrayList<>();
            String sql = "select * from spm.test";
            Object[] params = testList.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Test test = new Test(id, content);
                List.add(test);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public Test getById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Test test = null;
        if (null != connection) {
            List<Object> list = new ArrayList<>();
            String sql = "select * from spm.test";
            Object[] params = list.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                if (id.equals(rs.getString("id"))) {
                    String content = rs.getString("content");
                    test = new Test(Integer.valueOf(id), content);
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return test;
    }

    @Override
    public int modify(Connection connection, Test test) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update spm.test set content=? where id = ? ";
            Object[] params = {test.getContent(), test.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public int deleteById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if (null != connection) {
            String sql = "delete from spm.test where id=?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }
}