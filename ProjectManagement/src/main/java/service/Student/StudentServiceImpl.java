package service.Student;

import Dao.BaseDao;
import Dao.student.StudentDao;
import Dao.student.StudentDaoImpl;
import Pojo.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    //业务层调用Dao层，所以我们要引入Dao层
    private StudentDao studentDao=new StudentDaoImpl() ;
    /**
     * 用户登录实现
     *
     * @param stuname
     * @param password
     * @return
     */
    @Override
    public Student login(String stuname, String password) {
        Connection connection = null;
        Student student = null;
        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            student = studentDao.getLoginStudent(connection,stuname);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        //匹配密码
        if (null != student) {
            if (!student.getPassword().equals(password)) {
                student = null;
            }
        }
        return student;
    }

    @Override
    public boolean add(Student student) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = studentDao.add(connection, student);
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
    public List<String> getStuNameList(){
        Connection connection = null;
        List<String> studentList = null;
        try {
            connection = BaseDao.getConnection();
            studentList = studentDao.getStuNameList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return studentList;
    }
}
