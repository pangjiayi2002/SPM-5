package Pojo;

public class Teacher {
    private int idteacher;
    private String teachername;
    private String password;

    public Teacher() {
    }

    public Teacher(int idteacher, String teachername, String password) {
        this.idteacher = idteacher;
        this.teachername = teachername;
        this.password = password;
    }

    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
