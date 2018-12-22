package pers.cabin.java.design.reactor;

import pers.cabin.java.design.reactor.constants.Event;
import pers.cabin.java.design.reactor.constants.enums.EventTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caiping
 * @create 2018/2/5 17:09
 * @Description 调度器。使用Demultiplexer选出可以执行处理的EventHandler，然后执行对EventHandler的调度
 */
public class EventDispatcher {
    Map<EventTypeEnum, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventTypeEnum, EventHandler>();

    Demultiplexer selector;

    EventDispatcher(Demultiplexer selector) {
        this.selector = selector;
    }

    public void registEventHandler(EventTypeEnum eventType, EventHandler eventHandler) {
        eventHandlerMap.put(eventType, eventHandler);

    }

    public void removeEventHandler(EventTypeEnum eventType) {
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents() {
        dispatch();
    }

    private void dispatch() {
        while (true) {
            List<Event> events = selector.select();

            for (Event event : events) {
                EventHandler eventHandler = eventHandlerMap.get(event.type);
                eventHandler.handle(event);
            }
        }
    }
}
