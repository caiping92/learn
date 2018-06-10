package pers.caiping.learn.model.reactor;

import pers.caiping.learn.model.reactor.constants.Event;

/**
 * @author caiping
 * @create 2018/2/5 17:16
 * @Description
 */
public class WriteEventHandler  extends EventHandler {
    @Override
    public void handle(Event event) {
        // step 1: encode a message to byte[]
        // step 2: submit a write task to IOWorker thread pool
    }
}
