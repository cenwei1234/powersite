package com.jialong.powersite.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提供一个 订阅通道 客户端连接此地址后 可以进行双向通信
 */
@ServerEndpoint("/ws/topic")
@Component
public class TopicServer {

    private static CopyOnWriteArrayList<TopicServer> topicServerSet = new CopyOnWriteArrayList<>();

    //与某个客户端的连接会话
    //session是websocket的session 通过它 可以向对应的客户端发送消息 客户端的onMessage事件会触发
    private Session session;

    private static final Logger log = LoggerFactory.getLogger(TopicServer.class);

    /**
     * 连接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session)
    {
        this.session = session;
        topicServerSet.add(this);
        log.debug("onOpen ---> {} 加入到订阅列表 有消息可以选择发送过去", session.getId());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose()
    {
        topicServerSet.remove(this); //从set中删除
        log.debug("onClose ---> {}取消订阅，消息将不再发过去",session.getId());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
        String returnMsg = "服务器收到客户端的消息:"+ message + ":服务器明白了";
        try {
            session.getBasicRemote().sendText(returnMsg);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    /**
     * websocket发生错误时候触发
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error)
    {
        log.error("发生错误");
        error.printStackTrace();
    }

    /**
     * 向所有订阅者群发消息 所有客户端都可以收到信息
     * 注意：本demo内推送是不具有消息队列的特性的 无法保存队列中的消息 如果某个客户端在此期间离线了 那么
     * 此客户端就将无法收到离线消息了
     * @param message 群发的消息
     * @return 成功推送的客户端个数 可用于统计推送到达率
     */
    public static int putMessage(String message)
    {
        AtomicInteger success_count = new AtomicInteger();
        topicServerSet.forEach(topicServer -> {
            try {
                topicServer.session.getBasicRemote().sendText(message);
                success_count.getAndIncrement();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        return success_count.get();
    }

}
