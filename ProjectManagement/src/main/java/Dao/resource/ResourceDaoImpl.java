package Dao.resource;

import Dao.BaseDao;
import Pojo.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao{
    //查询某一种资料 图书/课件/案例
    public ArrayList<Resource> getResourceListByType(Connection connection,String type) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Resource> ResourceList=new ArrayList<>();
        if(null!=connection){
            String sql="select * from studyresource where resource_type=?";
            Object[] params={type};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                Resource resource=new Resource();
                resource.setId(rs.getInt("id"));
                resource.setName(rs.getString("name"));
                resource.setSrc(rs.getString("src"));
                resource.setResource_type(rs.getString("resource_type"));
                ResourceList.add(resource);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return ResourceList;
    }

    //添加资料
    public int add(Connection connection,Resource resource){
        PreparedStatement pstm=null;
        int updateRows=0;
        if(null!=connection){
            String sql="insert into spm.studyresource(name,src,resource_type)value(?,?,?)";
            Object[] params={resource.getName(),resource.getSrc(),resource.getResource_type()};
            updateRows=BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateRows;
    }
}
