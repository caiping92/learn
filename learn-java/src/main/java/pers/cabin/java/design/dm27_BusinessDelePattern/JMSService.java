package pers.cabin.java.design.dm27_BusinessDelePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
