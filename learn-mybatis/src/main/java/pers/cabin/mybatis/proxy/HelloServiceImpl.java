package pers.cabin.mybatis.proxy;

/**
 * Created by caiping on 2017/3/16.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello "+name);
    }
}
