package com.moh.yehia.websocket.config;

import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class UserHandshakeHandler extends DefaultHandshakeHandler {
    private final Logger log = LoggerFactory.getLogger(UserHandshakeHandler.class);

    @Override
    protected Principal determineUser(@NonNull ServerHttpRequest request, @NonNull WebSocketHandler wsHandler, @NonNull Map<String, Object> attributes) {
        String randomUserId = UUID.randomUUID().toString();
        log.info("User ID: {} has opened the page", randomUserId);
        return new UserPrincipal(randomUserId);
    }
}
