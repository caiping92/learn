package pers.cabin.java.design.dm32_ServiceLocationPattern;

/**
 * 创建实体服务
 * Created by caiping on 2017/3/3.
 */
public class Service1 implements Service {
    @Override
    public void execute() {
        System.out.println("Executing Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }
}
