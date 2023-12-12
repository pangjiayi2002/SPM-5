package Dao.notice;

import Dao.BaseDao;
import Pojo.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao{

    @Override
    public int add(Connection connection, Notice notice) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.notice (title,content,createTime) values(?,?,?)";
            Object[] params = {notice.getTitle(), notice.getContent(),notice.getCreateTime()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public List<Notice> getAll(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Notice> List=new ArrayList<>();
        if(null!=connection){
            List<Object> NoticeList=new ArrayList<>();
            String sql="select * from spm.notice";
            Object[] params=NoticeList.toArray();
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String createTime=rs.getString("createTime");
                Notice notice=new Notice(id,title,content,createTime);
                List.add(notice);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public Notice getById(Connection connection,String id) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Notice notice=null;
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select * from spm.notice";
            Object[] params=list.toArray();
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                if (id.equals(rs.getString("id"))){
                    String title=rs.getString("title");
                    String content=rs.getString("content");
                    String createTime=rs.getString("createTime");
                    notice=new Notice(title,content,createTime);
                }
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return notice;
    }

    @Override
    public int modify(Connection connection, Notice notice) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update spm.notice set title=?,content=? where createTime = ? ";
            Object[] params = {notice.getTitle(),notice.getContent(),notice.getCreateTime()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    public int deleteById(Connection connection, String id)throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if (null != connection) {
            String sql = "delete from spm.notice where id=?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }
}