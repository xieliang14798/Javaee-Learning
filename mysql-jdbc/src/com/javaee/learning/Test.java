package com.javaee.learning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getCon();
        PreparedStatement statement = con.prepareStatement
                ("SELECT * from users where password = ? ");
        statement.setObject(1, "23");
        ResultSet res = statement.executeQuery();
        List<User> data = new ArrayList<>();
        while (res.next()) {
            data.add(new User(
                    res.getInt("id"),
                    res.getString("username"),
                    res.getString("password")
            ));
        }
        JDBCUtils.close(con, statement, res);
        for (User user : data) {
            System.out.println(user.toString());
        }
    }
}
