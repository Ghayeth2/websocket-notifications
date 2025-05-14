package com.websocket.app.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @MessageMapping("/counter")
    @SendTo("/topic/counter")
    public Integer counter(Integer counter) {
        System.out.println("Current count: " + counter);
        return counter;
    }
}
