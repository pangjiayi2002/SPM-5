package Pojo;

public class Teacher {
    private String idteacher;
    private String teachername;
    private String password;

    public Teacher() {
    }

    public Teacher(String idteacher, String teachername, String password) {
        this.idteacher = idteacher;
        this.teachername = teachername;
        this.password = password;
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
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
