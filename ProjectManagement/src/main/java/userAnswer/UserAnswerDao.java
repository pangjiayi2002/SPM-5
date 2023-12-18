package userAnswer;

import Pojo.StuTask;
import Pojo.UserAnswer;

import java.sql.Connection;
import java.util.List;

public interface UserAnswerDao {
    int add(Connection connection, UserAnswer userAnswer) throws Exception;
    List<StuTask> getAll(Connection connection,Integer userId)throws Exception;

    List<UserAnswer> getAllWithTeacher(Connection connection,Integer taskId)throws Exception;
    UserAnswer getById(Connection connection,String id)throws Exception;
    int modifyScore(Connection connection, UserAnswer userAnswer) throws Exception;

}
