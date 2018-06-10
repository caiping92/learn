package pers.cabin.mybatis.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * cglib 不能代理 final 修饰的方法
 * Created by caiping on 2017/3/16.
 */
public class HelloServiceGgLibProxy implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);

        //闯将代理对象
        return enhancer.create();
    }

    /**
     * 回调方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 动态代理开始");
        Object returnObject = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 反射方法调用结束");
        return returnObject;
    }


    @Test
    public void testCgLibProxy() {
        HelloServiceGgLibProxy cgLibProxy = new HelloServiceGgLibProxy();
        HelloService instance = (HelloService) cgLibProxy.getInstance(new HelloServiceImpl());
        instance.sayHello("CGLIB 代理");
    }
}
