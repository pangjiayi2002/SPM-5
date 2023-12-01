package Pojo;

public class Student {
    private int idstudent;
    private String stuname;
    private String password;

    public Student() {
    }

    public Student(int idstudent, String stuname, String password) {
        this.idstudent = idstudent;
        this.stuname = stuname;
        this.password = password;
    }

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
