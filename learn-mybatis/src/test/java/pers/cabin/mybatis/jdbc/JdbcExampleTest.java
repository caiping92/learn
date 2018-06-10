package pers.cabin.mybatis.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by caiping on 2017/3/12.
 */
public class JdbcExampleTest {


    @Test
    public void testGetConn() {

        Connection conn = JdbcExample.getConnection();

        if (conn!=null){
            System.out.println("数据库连接成功");
        }
    }


    @Test
    public void testGetRoleById() {
        getRoleById(1);
    }


    public void getRoleById(int id) {
        String sql = "SELECT  id ,role_name,note FROM t_role WHERE id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps =JdbcExample.getConnection() .prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Integer roleId = rs.getInt("id");
                String roleName = rs.getString("role_name");
                String note = rs.getString("note");

                System.out.println(roleId+"-"+roleName+"-"+note);
            }

            JdbcExample.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


