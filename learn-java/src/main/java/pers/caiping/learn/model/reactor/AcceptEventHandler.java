package pers.caiping.learn.model.reactor;

import pers.caiping.learn.model.reactor.constants.Event;
import pers.caiping.learn.model.reactor.constants.enums.EventTypeEnum;

/**
 * @author caiping
 * @create 2018/2/5 17:15
 * @Description
 */
public class AcceptEventHandler  extends EventHandler {
    private Demultiplexer selector;

    public AcceptEventHandler(Demultiplexer selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (event.type == EventTypeEnum.ACCEPT) {

            Event readEvent = new Event();
            readEvent.source = event.source;
            readEvent.type = EventTypeEnum.READ;

            selector.addEvent(readEvent);
        }
    }
}
