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
}
