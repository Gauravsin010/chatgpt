package com.example.ChatGpt.service;

import com.example.ChatGpt.Exception.CustomException;
import com.example.ChatGpt.model.chat.Request.ChatRequest;
import com.example.ChatGpt.model.chat.Request.Messages;
import com.example.ChatGpt.model.chat.Response.ChatResponse;
import com.example.ChatGpt.util.ChatGptUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGptServiceImpl implements ChatGptService{

    @Autowired
    private ChatGptUtility chatGptUtility;

    public static final Logger logger = LoggerFactory.getLogger(ChatGptServiceImpl.class);

    //curl https://api.openai.com/v1/chat/completions \
//            -H "Content-Type: application/json" \
//            -H "Authorization: Bearer $OPENAI_API_KEY" \
//            -d '{
//            "model": "gpt-3.5-turbo",
//            "messages": [
//    {
//        "role": "system",
//            "content": "You are a helpful assistant."
//    },
//    {
//        "role": "user",
//            "content": "Hello!"
//    }
//    ]
//}'


    //    {
//      *  "id": "chatcmpl-123",
//      *      "object": "chat.completion",
//      *      "created": 1677652288,
//       *     "model": "gpt-3.5-turbo-0613",
//       *     "system_fingerprint": "fp_44709d6fcb",
//       *     "choices": [{
//        "index": 0,
//                "message": {
//            "role": "assistant",
//                    "content": "\n\nHello there, how may I assist you today?",
//        },
//        "finish_reason": "stop"
//    }],
//        "usage": {
//        "prompt_tokens": 9,
//                "completion_tokens": 12,
//                "total_tokens": 21
//    }
//    }

    @Override
    public String chatGptSearch(String text) {
        try {
            logger.info("Inside chatGptSearch service class");
            ChatRequest request = new ChatRequest();
            request.setModel("gpt-3.5-turbo");

            List<Messages> messages = new ArrayList<>();
            Messages mess = new Messages();
            mess.setRole("user");
            mess.setContent(text);
            messages.add(mess);
            request.setMessages(messages);
            logger.info("Messages " + messages);

            ResponseEntity<ChatResponse> response = chatGptUtility.chatSearch(request);
            String result = response.getBody().getChoices().get(0).getMessage().getContent();
            return result;

        } catch (Exception ex){
            logger.info("Exception inside chatGptSearch method");
            throw new CustomException("Exception inside chatGptSearch method", ex);
        }
    }

}
