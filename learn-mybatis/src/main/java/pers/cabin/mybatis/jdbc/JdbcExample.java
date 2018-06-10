package pers.cabin.mybatis.jdbc;

import java.sql.*;

/**
 * Created by caiping on 2017/3/11.
 */
public class JdbcExample {

    private JdbcExample() {
    }
    private static Connection conn = null;

    /**
     * 获取链接
     * @return
     */
    public static synchronized Connection getConnection() {
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/practice_mysql?zeroDateTimeBehavior=convertToNull";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭链接
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
