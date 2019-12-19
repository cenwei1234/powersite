package com.jialong.powersite.modular.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class SiteOperationDealTimerTask extends TimerTask {

    private static Logger logger = LoggerFactory.getLogger(SiteOperationDealTimerTask.class);

    private String name;

    public SiteOperationDealTimerTask(String inputName){
        name = inputName;
    }

    public void run() {
        logger.info("Current exec name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
