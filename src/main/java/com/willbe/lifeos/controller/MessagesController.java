package com.willbe.lifeos.controller;

import com.willbe.lifeos.message.Greeting;
import com.willbe.lifeos.message.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * Creation date: 10/20/15
 *
 * @author Vitalii Siryi
 */
@Controller
public class MessagesController {

    @MessageMapping("/hello")
    @SendToUser("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
