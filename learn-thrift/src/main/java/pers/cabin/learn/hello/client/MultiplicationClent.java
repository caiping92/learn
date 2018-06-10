package pers.cabin.learn.hello.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import pers.cabin.learn.hello.MultipalicationService;

/**
 * Created by caiping on 2017/9/14.
 */
public class MultiplicationClent {

    public static void main(String[] args){

        TTransport transport;

        transport = new TSocket("localhost", 9090);
        try {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);

            MultipalicationService.Client client = new MultipalicationService.Client(protocol);

            perform(client);

            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }


    }

    private static void perform(MultipalicationService.Client client) throws TException {

        int n1 = 2;
        int n2 = 5;
        int product = client.multiply(n1, n2);
        System.out.println(n1 + "* " + n2+"="+(n1*n2));
    }
}
