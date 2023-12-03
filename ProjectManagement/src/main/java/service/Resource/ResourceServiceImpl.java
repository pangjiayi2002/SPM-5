package service.Resource;

import Dao.BaseDao;
import Dao.resource.ResourceDao;
import Dao.resource.ResourceDaoImpl;
import Pojo.Resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResourceServiceImpl implements ResourceService{
    private ResourceDao resourceDao=new ResourceDaoImpl();
    public ArrayList<Resource> getResourceListByType(String type){
        ArrayList<Resource> ResourceList=null;
        Connection connection=null;
        try{
            connection= BaseDao.getConnection();
            ResourceList=resourceDao.getResourceListByType(connection,type);
        } catch (SQLException e) {
            e.printStackTrace();
            ResourceList=null;
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return ResourceList;
    }

    public boolean add(Resource resource){
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = resourceDao.add(connection, resource);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
