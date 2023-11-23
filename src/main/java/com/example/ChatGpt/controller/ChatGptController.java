package com.example.ChatGpt.controller;

import com.example.ChatGpt.Exception.CustomException;
import com.example.ChatGpt.service.ChatGptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    public static final Logger logger = LoggerFactory.getLogger(ChatGptController.class);

    @PostMapping("/search/text")
    public String chatGptSearch(@RequestHeader String text){
        try {
            logger.info("Inside ChatGptSearch method");
            logger.info("Text received " + text);
            String response = chatGptService.chatGptSearch(text);
            return response;

        } catch (Exception ex){
            logger.info("Exception inside ChatGptSearch method");
            throw new CustomException("Exception inside ChatGptSearch method", ex);
        }
    }
}
