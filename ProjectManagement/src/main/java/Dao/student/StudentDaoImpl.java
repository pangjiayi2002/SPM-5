package Dao.student;

import Dao.BaseDao;
import Pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    /**
     * 得到要登录的用户
     *
     * @param connection
     * @param stuname
     * @return
     */
    @Override
    public Student getLoginStudent(Connection connection, String stuname) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Student student= null;
        try {
            if (null != connection) {
                String sql = "select * from smbms_user where userCode=?";
                Object[] params = {stuname};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    student = new Student();
                    student.setIdstudent(rs.getInt("idstudent"));
                    student.setStuname(rs.getString("stuname"));
                    student.setPassword(rs.getString("password"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }


    @Override
    public int add(Connection connection, Student student) {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into spm.student (stuname,password) values(?,?)";
            Object[] params = {student.getStuname(), student.getPassword()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    public List<String> getStuNameList(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<String> StuNameList=new ArrayList<>();
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select stuname from student";
            Object[] params=list.toArray();
            rs=BaseDao.execute(connection,pstm,rs,String.valueOf(sql),params);
            while(rs.next()){
                StuNameList.add(rs.getString("stuname"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return StuNameList;
    }
}
