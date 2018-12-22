package pers.cabin.java.design.adapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class CN220VInterfaceImpl implements CN220VInterface {
    @Override
    public void connect() {
        log.info("接通220V电源，开始工作......");
    }
}
