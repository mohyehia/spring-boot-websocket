package com.moh.yehia.websocket.service;

import com.moh.yehia.websocket.dto.ResponseMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyForChanges(String message) {
        simpMessagingTemplate.convertAndSend("/topic/messages", new ResponseMessage(message));
    }

    public void sendNotifications() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            notifyForChanges("Proceeded count of " + i);
            Thread.sleep(1500); // simulate performing any task that takes time
            System.out.println("Notification sent");
        }
    }

    public void sendProgress() throws InterruptedException {
        for (int i = 0; i <= 10; i++) {
            simpMessagingTemplate.convertAndSend("/topic/progress", i * 10);
            Thread.sleep(1500);
            System.out.println("Progress sent");
        }
    }
}
