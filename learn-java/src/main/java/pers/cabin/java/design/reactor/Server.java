package pers.cabin.java.design.reactor;

import pers.cabin.java.design.reactor.constants.enums.EventTypeEnum;

/**
 * @author caiping
 * @create 2018/2/5 17:17
 * @Description
 */
public class Server {
    Demultiplexer selector = new Demultiplexer();
    EventDispatcher eventLooper = new EventDispatcher(selector);
    Acceptor acceptor;

    public Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventTypeEnum.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }
}
