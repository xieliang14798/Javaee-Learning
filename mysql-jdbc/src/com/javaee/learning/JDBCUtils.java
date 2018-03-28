package com.javaee.learning;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private JDBCUtils() {
    }

    private static Connection con;

    static {
        try {
            /*获取数据库配置*/
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
            Properties pro = new Properties();
            pro.load(in);
            String driverClass = pro.getProperty("driverClass");
            String url = pro.getProperty("url");
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");
            /*连接数据库*/
            Class.forName(driverClass);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e.toString() + "数据库连接失败");
        }
    }

    public static Connection getCon() {
        return con;
    }

    public static void close(Connection con, Statement stat) {
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement stat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
