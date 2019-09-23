package top.ban.controller;

import org.springframework.web.bind.annotation.RestController;
import top.ban.common.util.JSON;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@ServerEndpoint("/socket/{userId}")
public class WebSocketController {
    private static volatile int onlineCount = 0;

    private Session session;
    private String userId;

    private static Map<String, WebSocketController> clients = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        clients.put(userId, this);
    }

    @OnClose
    public void onClose() {
        System.out.println("####### closed! #######");
        clients.remove(this.userId);
    }

    @OnMessage
    public void onMessage(String message) {
        String msg = "####### msg: " + message;
        try {
            TestData data = JSON.parse(message, TestData.class);

            Map<String, Object> data2 = new HashMap<>();
            data2.put("name", "banyq");
            data2.put("age", 18);
            data2.put("data", new int[]{1, 2, 3});
            sendMessage(data2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(message);
        }
    }

    private void sendMessage(Object message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(JSON.stringify(message));
        }
    }
}

class TestData {
    private String name;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
