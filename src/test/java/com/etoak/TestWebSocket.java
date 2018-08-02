package com.etoak;

import com.etoak.service.WebSocket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWebSocket
{
    @Autowired
    private WebSocket webSocket;
    @Test
    public void sendMessage(){
        webSocket.sendMessage("收到消息了吗啊" );
    }
}
