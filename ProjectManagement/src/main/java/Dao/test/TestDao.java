
package Dao.test;

import Pojo.Test;

import java.sql.Connection;
import java.util.List;

public interface TestDao {
    int add(Connection connection, Test test) throws Exception;
    List<Test> getAll(Connection connection)throws Exception;
    Test getById(Connection connection,String id)throws Exception;
    int modify(Connection connection, Test notice) throws Exception;
    public int deleteById(Connection connection, String id)throws Exception;

}
