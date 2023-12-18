package service.userAnswer;

import Pojo.StuTask;
import Pojo.UserAnswer;

import java.util.List;

public interface UserAnswerService {
    public boolean add(UserAnswer userAnswer);

    List<StuTask> getAll(Integer userId) throws Exception;

    List<UserAnswer> getAllWithTeacher(Integer taskId) throws Exception;

    UserAnswer getById(String id);

    public boolean modify(UserAnswer userAnswer);

}
