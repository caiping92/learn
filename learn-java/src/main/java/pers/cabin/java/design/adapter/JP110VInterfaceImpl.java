package pers.cabin.java.design.adapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class JP110VInterfaceImpl implements JP110VInterface {
    @Override
    public void connect() {
        log.info("接通110V电源，开始工作....");
    }
}
