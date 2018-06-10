package pers.caiping.learn.model.reactor;

import pers.caiping.learn.model.reactor.constants.Event;

/**
 * @author caiping
 * @create 2018/2/5 17:14
 * @Description 时间处理器
 */
public abstract class EventHandler {
    Source source;

    public abstract void handle(Event event);

    public Source getSource() {
        return source;
    }
}
