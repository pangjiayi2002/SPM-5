package Dao.task;

import Pojo.Task;

import java.sql.Connection;
import java.util.List;

public interface TaskDao {
    int add(Connection connection, Task task) throws Exception;
    List<Task> getAll(Connection connection)throws Exception;
    Task getById(Connection connection,String id)throws Exception;
    int modify(Connection connection, Task notice) throws Exception;
    public int deleteById(Connection connection, String id)throws Exception;

}
