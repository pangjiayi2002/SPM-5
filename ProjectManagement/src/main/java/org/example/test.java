package org.example;

import Dao.BaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class test {
    public static void main(String[] args) {
        String driver;
        String url;
        String username;
        String password;

            Properties params = new Properties();
            String configFile = "db.properties";
            InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
            try {
                params.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver = params.getProperty("driver");
            url = params.getProperty("url");
            username = params.getProperty("username");
            password = params.getProperty("password");

        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if (connection!=null){
                System.out.println("连接成功");
            }else {
                System.out.println("连接失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
