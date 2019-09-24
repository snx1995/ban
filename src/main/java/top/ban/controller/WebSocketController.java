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

    }

    public void sendMessage(Object message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(JSON.stringify(message));
        }
    }
}
