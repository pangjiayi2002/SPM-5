package Dao.student;

import Pojo.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentDao {
    /**
     * 通过userCode获取User
     *
     * @param connection
     * @param stuname
     * @return
     * @throws Exception
     */
    Student getLoginStudent(Connection connection, String stuname) throws Exception;

    int add(Connection connection, Student student) throws Exception;

    List<String> getStuNameList(Connection connection)throws Exception;
}
