package pers.cabin.jichu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Created by caiping on 2017/9/12.
 */
public class TestDataSourceWithJNDI {

    /**
     * JNDI 名称
     */
    private static String MYSQL_JNDI_NAME = "java:/comp/db/evn/mysql";

    public static void main(String[] args) throws SQLException, NamingException {
        // 初始化名称服务环境
        Context ctx = null;
        try {
            Hashtable env = new Hashtable(5);
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.fscontext.RefFSContextFactory");  //;//指明用文件系统作为JNDI服务器
            env.put(Context.PROVIDER_URL, "file:D:/tmp");
            ctx = new javax.naming.InitialContext(env);
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

        bind(ctx, MYSQL_JNDI_NAME);
        DataSource dataSouce = (DataSource) ctx.lookup(MYSQL_JNDI_NAME);

        if (dataSouce != null) {
            Connection connection = dataSouce.getConnection();
            if (connection != null) {
                System.out.println(connection);
                PreparedStatement ps = connection.prepareStatement("SELECT CURRENT_TIMESTAMP FROM meta_table_info");

                final ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getTimestamp(1));
                }

                rs.close();
                ps.close();
                connection.close();
                System.out.println("使用 dataSouces 方式 ，Connection 连接成功");
            }
        }

    }


    static void bind(Context ctx, String ln)
            throws NamingException, SQLException {
// 创建一个OracleDataSource实例
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/datacube");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("datacube");
        dataSource.setPortNumber(3306);
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // 把MysqlDataSource实例注册到JNDI中
        System.out.println("Doing a bind with the logical name : " + ln);
        ctx.bind(ln, dataSource);       ///关键的一步(绑定后会在 /JNDI /下面建立一个名字为.bindings的文件)
        System.out.println("Successfully bound");
    }

}
