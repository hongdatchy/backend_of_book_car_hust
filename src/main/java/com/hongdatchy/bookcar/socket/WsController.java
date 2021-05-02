package com.hongdatchy.bookcar.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    @MessageMapping("/hello-msg-mapping")
    @SendTo("/topic/greetings")
    public Object sendMessage(@Payload Object object) {
        return object;
    }

}
