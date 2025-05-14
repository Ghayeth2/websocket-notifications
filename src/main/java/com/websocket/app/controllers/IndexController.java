package com.websocket.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/app/notifications")
public class IndexController {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
