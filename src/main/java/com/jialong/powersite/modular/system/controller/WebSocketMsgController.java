package com.jialong.powersite.modular.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableScheduling
public class WebSocketMsgController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 最基本的服务器端主动推送消息给前端
     * @return
     * @throws Exception
     */
    @Scheduled(fixedRate = 1000)
    public String serverTime() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        messagingTemplate.convertAndSend("/topicTest/servertime", df.format(new Date()));
        return "servertime";
    }
}
