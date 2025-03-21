package com.moh.yehia.websocket.controller;

import com.moh.yehia.websocket.service.WebSocketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @GetMapping("/messages/send/{message}")
    public void sendMessage(@PathVariable String message) {
        webSocketService.notifyForChanges(message);
    }

    @GetMapping("/messages/notifications")
    public void sendNotification() throws InterruptedException {
        webSocketService.sendNotifications();
    }

    @GetMapping("/messages/progress")
    public void sendProgress() throws InterruptedException {
        webSocketService.sendProgress();
    }
}
