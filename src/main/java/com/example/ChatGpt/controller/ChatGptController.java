package com.example.ChatGpt.controller;

import com.example.ChatGpt.Exception.CustomException;
import com.example.ChatGpt.dao.Chats;
import com.example.ChatGpt.repo.ChatsRepo;
import com.example.ChatGpt.service.ChatGptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @Autowired
    private ChatsRepo chatsRepo;

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

    @GetMapping("/allChats")
    public List<Chats> getAllChats(){
        try {
            logger.info("Inside getAllChats method");
            return chatsRepo.findAll();
        } catch (Exception ex){
            logger.info("Exception inside getAllChats method");
            throw new CustomException("Exception inside getAllChats method", ex);
        }
    }

    @PostMapping("/create/image")
    public String createImage(@RequestHeader String text){
        try {
            logger.info("Inside createImage method");
            logger.info("Text received " + text);
            String response = chatGptService.createImage(text);
            return response;

        } catch (Exception ex){
            logger.info("Exception inside createImage method");
            throw new CustomException("Exception inside createImage method", ex);
        }
    }

}
