package com.example.SpringBoot_ChatAI;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ChatModel chatModel;

    public Controller(ChatModel chatModel) {
        this.chatModel = chatModel;
    }


    @GetMapping("/")
    public String prompt(@RequestParam String msg) {
        return chatModel.call(msg);
    }
}
