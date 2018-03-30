package com.javaee.learning;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Test {
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        String sql = "SELECT * FROM users where password = ?";
        try {
            List<User> userList = qr.query(sql, new BeanListHandler<>(User.class),23);
            for (User user : userList) {
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
