package pers.cabin.java.design.reactor;

import pers.cabin.java.design.reactor.constants.Event;

/**
 * @author caiping
 * @create 2018/2/5 17:15
 * @Description
 */
public class ReadEventHandler extends EventHandler {
    // private Pipeline pipeline;

    @Override
    public void handle(Event event) {
        // create channel with a pipeline
        // register the channel to this event dispatcher or a child event dispatcher


        // handle event use the pipeline :
        // step 1:  read to a frame buffer
        // step 2:  use frame decoder to decode buffer as a message (maybe a business object)
        // step 3:  handle the message or submit the message to business thread pool
        // step 4:  register a message event

    }

}
