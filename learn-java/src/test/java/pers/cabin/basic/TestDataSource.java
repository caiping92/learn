package pers.cabin.basic;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * http://wallimn.iteye.com/blog/1893358
 * http://www.jianshu.com/p/919334bee6bf
 *
 * Created by caiping on 2017/9/13.
 */
public class TestDataSource {

    @Test
    public void testDataSource() throws SQLException {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/datacube");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setServerName("localhost");

        Connection connection = ds.getConnection();
        if (connection != null) {
            final Statement st = connection.createStatement();
            final ResultSet rs = st.executeQuery("SELECT CURRENT_TIMESTAMP,table_name FROM meta_table_info");
            while (rs.next()) {
                System.out.println(rs.getTimestamp(1));
                System.out.println(rs.getString(2));
            }
        }
    }

    @Test
    public void testDataSourceWithPool() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/datacube");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("root");

        Connection connection = ds.getConnection();
        if (connection != null) {
            final Statement st = connection.createStatement();
            final ResultSet rs = st.executeQuery("SELECT CURRENT_TIMESTAMP,table_name FROM meta_table_info");
            while (rs.next()) {
                System.out.println(rs.getTimestamp(1));
                System.out.println(rs.getString(2));
            }
        }
    }
}
