package com.example.SpringBoot_ChatAI;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatPromptTemplate;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private final ChatModel chatModel;

    public Controller(ChatModel chatModel) {
        this.chatModel = chatModel;
    }


    @GetMapping("/")
    public String prompt(@RequestParam(defaultValue = "Hi") String msg) {
        String message = """
                give only 3 {v} name
                """;
        PromptTemplate temp = new PromptTemplate(message);
        Prompt prompt = temp.create(Map.of("v",msg));
        return chatModel.call(prompt.getContents());
    }
}
