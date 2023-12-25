package Dao.userTestAnswer;

import Dao.BaseDao;
import Pojo.StuTest;
import Pojo.UserTestAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserTestAnswerDaoImpl implements UserTestAnswerDao {

    @Override
    public int add(Connection connection, UserTestAnswer userTestAnswer) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.user_testanswer (stu_id,test_id,answer) values(?,?,?)";
            Object[] params = {userTestAnswer.getStuId(), userTestAnswer.getTestId(), userTestAnswer.getAnswer()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public List<StuTest> getAll(Connection connection,Integer userId) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<StuTest> List = new ArrayList<>();
        if (null != connection) {
            String sql = "select t.*,ua.answer,ua.score from test t left join (select * from user_testanswer where stu_id = ?) ua on t.id = ua.test_id ";
            Object[] params = {userId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String answer = rs.getString("answer");
                Double score = rs.getDouble("score");
                StuTest stuTest = new StuTest();
                stuTest.setId(id);
                stuTest.setContent(content);
                stuTest.setAnswer(answer);
                stuTest.setScore(score);
                List.add(stuTest);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public List<UserTestAnswer> getAllWithTeacher(Connection connection, Integer testId) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<UserTestAnswer> List = new ArrayList<>();
        if (null != connection) {
            List<Object> testList = new ArrayList<>();
            String sql = "select ua.id,ua.score,s.stuname,t.content from user_testanswer ua inner join student s on ua.stu_id = s.idstudent inner join test t on ua.test_id = t.id where ua.test_id = ?";
            Object[] params = {testId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                UserTestAnswer userTestAnswer = new UserTestAnswer();
                userTestAnswer.setId(rs.getInt("id"));
                userTestAnswer.setScore(rs.getDouble("score"));
                userTestAnswer.setStuName(rs.getString("stuname"));
                userTestAnswer.setTestName(rs.getString("content"));
                List.add(userTestAnswer);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public UserTestAnswer getById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        UserTestAnswer userTestAnswer = null;
        if (null != connection) {
            List<Object> list = new ArrayList<>();
            String sql = "select ua.id,ua.answer,t.content from spm.user_testanswer ua inner join test t on ua.test_id = t.id";
            Object[] params = list.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                if (id.equals(rs.getString("id"))) {
                    userTestAnswer = new UserTestAnswer();
                    userTestAnswer.setId(rs.getInt("id"));
                    userTestAnswer.setAnswer(rs.getString("answer"));
                    userTestAnswer.setTestName(rs.getString("content"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userTestAnswer;
    }


    @Override
    public int modifyScore(Connection connection, UserTestAnswer userTestAnswer) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update spm.user_testanswer set score = ? where id = ? ";
            Object[] params = {userTestAnswer.getScore(), userTestAnswer.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

}