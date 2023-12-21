package Dao.userTestAnswer;

import Pojo.StuTest;
import Pojo.UserTestAnswer;

import java.sql.Connection;
import java.util.List;

public interface UserTestAnswerDao {
    int add(Connection connection, UserTestAnswer userTestAnswer) throws Exception;
    List<StuTest> getAll(Connection connection,Integer userId)throws Exception;

    List<UserTestAnswer> getAllWithTeacher(Connection connection,Integer testId)throws Exception;
    UserTestAnswer getById(Connection connection,String id)throws Exception;
    int modifyScore(Connection connection, UserTestAnswer userTestAnswer) throws Exception;

}
