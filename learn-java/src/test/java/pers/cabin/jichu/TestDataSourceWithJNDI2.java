package pers.cabin.jichu;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * http://www.nailedtothex.org/roller/kyle/entry/how-to-bind-lookup-a
 * Created by caiping on 2017/9/12.
 */
public class TestDataSourceWithJNDI2 {

    private static final String JNDI = "java:comp/env/jdbc/database";

    public static void main(String[] args) throws Exception {
        bind();
        lookup();
    }

    private static void bind() throws NamingException {
//        Hashtable env = new Hashtable();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
//        env.put(Context.URL_PKG_PREFIXES, "org.apache.naming");

        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
        final MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/datacube");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setServerName("localhost");
        final Context context = new InitialContext();
        try {
            context.createSubcontext("java:");
            context.createSubcontext("java:comp");
            context.createSubcontext("java:comp/env");
            context.createSubcontext("java:comp/env/jdbc");
            context.bind(JNDI, ds);
        } finally {
            context.close();
        }
    }

    private static void lookup() throws NamingException, SQLException {
        final Context context = new InitialContext();
        try {
            final DataSource ds = (DataSource) context.lookup(JNDI);
            try (final Connection cn = ds.getConnection();
                 final Statement st = cn.createStatement();
                 final ResultSet rs = st.executeQuery("SELECT CURRENT_TIMESTAMP FROM meta_table_info")) {
                while (rs.next()) {
                    System.out.println(rs.getTimestamp(1));
                }
            }
        } finally {
            context.close();
        }
    }
}
