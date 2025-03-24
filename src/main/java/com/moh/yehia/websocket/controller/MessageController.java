package com.moh.yehia.websocket.controller;

import com.moh.yehia.websocket.dto.MessageDTO;
import com.moh.yehia.websocket.dto.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MessageController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage retrieveMessage(MessageDTO messageDTO) throws InterruptedException {
        Thread.sleep(3000);
        return new ResponseMessage(messageDTO.content());
    }

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public ResponseMessage retrievePrivateMessage(MessageDTO messageDTO, Principal principal) throws InterruptedException {
        Thread.sleep(1500);
        return new ResponseMessage("Sending private message to user: " + principal.getName() + " with content: " + messageDTO.content());
    }
}
