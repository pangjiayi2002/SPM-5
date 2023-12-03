package Dao.resource;

import Pojo.Resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ResourceDao {
    //根据用户选择菜单上的学习资料种类找到所有的学习资料
    ArrayList<Resource> getResourceListByType(Connection connection, String type) throws SQLException;

    //添加学习资料
    int add(Connection connection,Resource resource)throws Exception;
}
