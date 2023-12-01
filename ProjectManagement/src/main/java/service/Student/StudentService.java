package service.Student;

import Pojo.Student;

public interface StudentService {
    /**
     * 用户登录
     *
     * @param stuname
     * @param password
     * @return
     */
    public Student login(String stuname, String password);

    /**
     * 增加用户信息
     *
     * @param student
     * @return
     */
    public boolean add(Student student);
}
