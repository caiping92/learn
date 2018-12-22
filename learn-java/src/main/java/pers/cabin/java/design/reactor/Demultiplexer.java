package pers.cabin.java.design.reactor;

import pers.cabin.java.design.reactor.constants.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author caiping
 * @create 2018/2/5 17:09
 * @Description 同步事件分离器
 */
public class Demultiplexer {
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    private Object lock = new Object();

    List<Event> select() {
        return select(0);
    }

    List<Event> select(long timeout) {
        if (timeout > 0) {
            if (eventQueue.isEmpty()) {
                synchronized (lock) {
                    if (eventQueue.isEmpty()) {
                        try {
                            lock.wait(timeout);
                        } catch (InterruptedException e) {
                            // ignore it
                        }
                    }
                }

            }
        }
        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);
        return events;
    }

    public void addEvent(Event e) {
        boolean success = eventQueue.offer(e);
        if (success) {
            synchronized (lock) {
                lock.notify();
            }

        }
    }
}
