package com.etoak.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
@Component
@ServerEndpoint(value = "/webSocket")
@Slf4j
public class WebSocket {
    private Session session;

    Set<WebSocket> set = new HashSet<WebSocket>(); // 非同步，非线程安全的Set
    Set<WebSocket> webSocketSet = Collections.synchronizedSet(set); // 返回了一个线程安全的Set
  //  private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    Map map  =new ConcurrentHashMap<String,String>();
    @OnOpen
    public void  onOpen(Session session){
        this.session =session;
        webSocketSet.add(this);
        log.info("【webSocket消息】 有新的连接，总数:{}",webSocketSet.size());
    }
    @OnClose
    public void onColse(){
        webSocketSet.remove(this);
        log.info("【webSocket消息】 连接断开，总数:{}",webSocketSet.size());
    }
    @OnMessage
    public void onMessage(String message){
        log.info("【webSocket消息】收到客户端发来的消息:{}",message);
    }
    public void sendMessage(String message){
        for(WebSocket webSocket :webSocketSet){
            log.info("【webSocet消息】广播消息,message:{}",message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
