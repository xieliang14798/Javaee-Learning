package com.javaee.learning;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        try {
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream
                    ("database.properties");
            Properties properties = new Properties();
            properties.load(in);
            String driverClass = properties.getProperty("driverClass");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setInitialSize(10);//初始化连接数
            dataSource.setMaxActive(8);//最大连接数量
            dataSource.setMaxIdle(5);//最大空闲数
            dataSource.setMinIdle(1);//最小空闲
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
