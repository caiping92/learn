package pers.cabin.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Intercepts 说明它是一个拦截器
 * @Signature 是注册拦截器签名的方法，只有签名满足条件才能拦截
 * type 可以使四大对象的某一个接口方法
 * args 则表示 该方法的参数
 *
 * Created by caiping on 2017/3/14.
 */
@Intercepts({ @Signature(
        type  = StatementHandler.class,  //需要拦截对象
        method = "update",     //需要拦截的方法
        args = {Statement.class}   //拦截方法的参数
)})
public class MyPlugin implements Interceptor{

    Properties props =null;

    /**
     * 代替拦截器的方法的内容
     *
      * @param invocation   责任链对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("before ....");
        //如果当前代理对象是一个非代理对象，那么它就回调用真是拦截对象的方法，如果不是 它会调度下一个插件代理对象的invoke方法
        Object obj = invocation.proceed();
        System.out.println("aftler .....");
        return obj;
    }

    /**
     * 生成代理对象，这里 常用 Mybatis 提供的 Plugin类的 wrap 方法
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        //使用Mybatis 提供的Plugin类生成代理对象
        System.out.println("调用生成代理对象 ....");
        return Plugin.wrap(target,this);
    }

    /**
     * 获取插件配置的属性，我们在Mybatis 的配置文件里去配置
     * @param props    是Mybatis 配置的参数
     */
    @Override
    public void setProperties(Properties props) {
        System.out.println(props.get("dbType"));
        this.props=props;
    }
}
