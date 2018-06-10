package pers.cabin.mybatis.utils;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import pers.cabin.mybatis.dao.RoleMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * 创建SQLSessionFactory 对象的两种方式
 * Created by caiping on 2017/3/12.
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 通过配置构建SessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream inputStream = null;
        if (inputStream == null) {
            String resource = "mybatis-config.xml";
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
                return sqlSessionFactory;
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 通过Configuration对象构建SQLSessionFactory
     * 初始化一个数据库连接池
     * 定义JDBC 的数据库事务管理方式
     * 用数据库连接池和事务管理方式创建一个数据库运行环境，并命名为development
     * 创建一个Configuration对象，并把数据库环境注册给它
     * 注册 别名
     * 加入映射器
     *
     * 使用SqlSessionFactoryBuilder创建SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactoryByConfugration() {

//        构建数据库连接池
        PooledDataSource pooledDataSource = new PooledDataSource();

        String driver ="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/practice_mysql?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "root";

        pooledDataSource.setDriver(driver);
        pooledDataSource.setUrl(url);
        pooledDataSource.setUsername(username);
        pooledDataSource.setPassword(password);

        //构建事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

//        创建运行环境
        Environment environment = new Environment("development", transactionFactory, pooledDataSource);

//        构建Configuration对象
        Configuration configuration = new Configuration(environment);

//        添加别名
//        configuration.getTypeAliasRegistry().registerAlias();

//        加入映射器
        configuration.addMapper(RoleMapper.class);

//        使用SqlSessionFactoryBuilder 构建SQLSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        return sqlSessionFactory;

    }
}
