package com.websocket.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * It is WebSocket STOMPing controller,
 * no need for HTTP endpoints in here to keep design clean.
 * Only adding the MessageMapping endpoints without the
 * HTTP (GetMapping, PostMapping, PutMapping, DeleteMapping, RequestMapping). 
 */
@RestController
public class NotificationsController {

    // Notifications Broadcasting endpoint
    @MessageMapping("/getMessages")
    @SendTo("/topic/notifications")
    public String sendNotifications(String message) {
        System.out.println("Received notification: " + message);
        return message;
    }
}
