package com.jialong.powersite.config;

import com.jialong.powersite.modular.system.service.impl.SiteOperationDealTimerTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;

@Configuration
public class MyTimer {

    @Bean
    public void testQuartzTrigger1() {
        Timer timer = new Timer();
        SiteOperationDealTimerTask myTimeTask = new SiteOperationDealTimerTask("No.1");
        timer.schedule(myTimeTask,2000L,1000L);
    }
}