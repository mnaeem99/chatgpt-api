package com.chat.aianswer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/generate-response")
    public String generateResponse(@RequestBody String prompt) {
        try {
            return openAIService.generateResponse(prompt);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating response";
        }
    }
}

