package service.userTestAnswer;

import Pojo.StuTest;
import Pojo.UserTestAnswer;

import java.util.List;

public interface UserTestAnswerService {
    public boolean add(UserTestAnswer userTestAnswer);

    List<StuTest> getAll(Integer userId) throws Exception;

    List<UserTestAnswer> getAllWithTeacher(Integer testId) throws Exception;

   UserTestAnswer getById(String id);

    public boolean modify(UserTestAnswer userTestAnswer);

}
