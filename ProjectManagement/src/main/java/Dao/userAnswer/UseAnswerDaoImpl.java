package Dao.userAnswer;

import Dao.BaseDao;
import Pojo.StuTask;
import Pojo.UserAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UseAnswerDaoImpl implements UserAnswerDao {

    @Override
    public int add(Connection connection, UserAnswer userAnswer) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.user_answer (stu_id,task_id,answer) values(?,?,?)";
            Object[] params = {userAnswer.getStuId(), userAnswer.getTaskId(), userAnswer.getAnswer()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public List<StuTask> getAll(Connection connection,Integer userId) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<StuTask> List = new ArrayList<>();
        if (null != connection) {
            String sql = "select t.*,ua.answer,ua.score from task t left join (select * from user_answer where stu_id = ?) ua on t.id = ua.task_id ";
            Object[] params = {userId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String answer = rs.getString("answer");
                Double score = rs.getDouble("score");
                StuTask stuTask = new StuTask();
                stuTask.setId(id);
                stuTask.setContent(content);
                stuTask.setAnswer(answer);
                stuTask.setScore(score);
                List.add(stuTask);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public List<UserAnswer> getAllWithTeacher(Connection connection, Integer taskId) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<UserAnswer> List = new ArrayList<>();
        if (null != connection) {
            List<Object> taskList = new ArrayList<>();
            String sql = "select ua.id,ua.score,s.stuname,t.content from user_answer ua inner join student s on ua.stu_id = s.idstudent inner join task t on ua.task_id = t.id where ua.task_id = ?";
            Object[] params = {taskId};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setScore(rs.getDouble("score"));
                userAnswer.setStuName(rs.getString("stuname"));
                userAnswer.setTaskName(rs.getString("content"));
                List.add(userAnswer);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return List;
    }

    @Override
    public UserAnswer getById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        UserAnswer userAnswer = null;
        if (null != connection) {
            List<Object> list = new ArrayList<>();
            String sql = "select ua.id,ua.answer,t.content from spm.user_answer ua inner join task t on ua.task_id = t.id";
            Object[] params = list.toArray();
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while (rs.next()) {
                if (id.equals(rs.getString("id"))) {
                    userAnswer = new UserAnswer();
                    userAnswer.setId(rs.getInt("id"));
                    userAnswer.setAnswer(rs.getString("answer"));
                    userAnswer.setTaskName(rs.getString("content"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userAnswer;
    }


    @Override
    public int modifyScore(Connection connection, UserAnswer userAnswer) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update spm.user_answer set score = ? where id = ? ";
            Object[] params = {userAnswer.getScore(), userAnswer.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

}