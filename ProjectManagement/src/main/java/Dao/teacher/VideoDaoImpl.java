package Dao.teacher;

import Dao.BaseDao;
import Pojo.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VideoDaoImpl implements VideoDao{

    //添加视频
    @Override
    public int add(Connection connection, Video video) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.video (title,src) values(?,?)";
            Object[] params = {video.getTitle(), video.getSrc()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    //得到视频标题
    @Override
    public List<String> getVideoSrcList(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<String> SrcList=new ArrayList<>();
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select title from spm.video";
            Object[] params=list.toArray();
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                SrcList.add(rs.getString("src"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return SrcList;
    }
}
