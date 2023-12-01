package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private static String url="jdbc:mysql://localhost:3306/spm?useUnicode=true&characterEncoding=utf-8";
    private static String username="root";
    private static String password="030818";
    public static Connection getConnection() throws Exception {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
