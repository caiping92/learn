package pers.cabin.learn.hello.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import pers.cabin.learn.hello.MultipalicationService;
import pers.cabin.learn.hello.handler.MultiplicationHandler;

/**
 * Created by caiping on 2017/9/14.
 */
public class MultiplicationServer {

    public static MultiplicationHandler handler;

    public static MultipalicationService.Processor<MultiplicationHandler> processor;

    public static void main(String[] args){
        handler = new MultiplicationHandler();
        processor = new MultipalicationService.Processor<>(handler);

         new Thread(() -> {
             simple(processor);

        }).start();


    }

    private synchronized static  void simple(MultipalicationService.Processor<MultiplicationHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);

            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("starting the siimple server .....");
            server.serve();

        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
