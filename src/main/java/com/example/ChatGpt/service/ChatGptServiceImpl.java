package com.example.ChatGpt.service;

import com.example.ChatGpt.Exception.CustomException;
import com.example.ChatGpt.model.chat.Request.ChatRequest;
import com.example.ChatGpt.model.chat.Request.Messages;
import com.example.ChatGpt.model.chat.Response.ChatResponse;
import com.example.ChatGpt.model.image.request.ImageRequest;
import com.example.ChatGpt.model.image.response.ImageResponse;
import com.example.ChatGpt.repo.ChatsRepo;
import com.example.ChatGpt.util.ChatGptUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGptServiceImpl implements ChatGptService{

    @Autowired
    private ChatGptUtility chatGptUtility;

    @Autowired
    private ChatsRepo chatsRepo;

    @Value("${image.model}")
    private String imageModel;

    @Value("${chatgpt.model}")
    private String chatModel;

    public static final Logger logger = LoggerFactory.getLogger(ChatGptServiceImpl.class);

    @Override
    public String chatGptSearch(String text) {
        try {
            logger.info("Inside chatGptSearch service class");
            ChatRequest request = new ChatRequest();
            request.setModel(chatModel);

            List<Messages> messages = new ArrayList<>();
            Messages mess = new Messages();
            mess.setRole("user");
            mess.setContent(text);
            messages.add(mess);
            request.setMessages(messages);
            logger.info("Messages " + messages);

            ResponseEntity<ChatResponse> response = chatGptUtility.chatSearch(request);
            ChatResponse chatResponse = response.getBody();
            if(chatResponse != null){
                String result = chatResponse.getChoices().get(0).getMessage().getContent();
                try {
                    logger.info("Saving data....");
                    chatsRepo.addChats(text, result);
                    logger.info("Data saved");
                } catch (Exception ex){
                    logger.info("Exception in saving data");
                    throw new CustomException("Exception in saving data", ex);
                }
                return result;
            } else {
                return "No Response from chat-gpt";
            }

        } catch (Exception ex){
            logger.info("Exception inside chatGptSearch method");
            throw new CustomException("Exception inside chatGptSearch method", ex);
        }
    }

    @Override
    public String createImage(String text) {
        try {
            logger.info("Inside createImage service class");
            ImageRequest request = new ImageRequest();
            request.setN(1);
            request.setModel(imageModel);
            request.setPrompt(text);

            logger.info("Request " + request);
            ResponseEntity<ImageResponse> response = chatGptUtility.createImage(request);
            ImageResponse imageResponse = response.getBody();
            if(imageResponse != null) {
                String url = imageResponse.getData().get(0).getUrl();
                try {
                    logger.info("Saving data....");
                    chatsRepo.addChats(text, url);
                    logger.info("Data saved");
                } catch (Exception ex){
                    logger.info("Exception in saving data");
                    throw new CustomException("Exception in saving data", ex);
                }
                return url;
            } else {
                return "No Response from dall-e";
            }

        } catch (Exception ex){
            logger.info("Exception inside createImage method");
            throw new CustomException("Exception inside createImage method", ex);
        }
    }


}
