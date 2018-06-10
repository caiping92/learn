package pers.cabin.learn.hello.handler;

import org.apache.thrift.TException;
import pers.cabin.learn.hello.MultipalicationService;

/**
 * Created by caiping on 2017/9/14.
 */
public class MultiplicationHandler implements MultipalicationService.Iface {


    @Override
    public int multiply(int n1, int n2) throws TException {
        System.out.println("multiply("+n1+","+n2+")");
        return n1*n2;
    }
}
