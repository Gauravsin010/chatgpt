package com.example.ChatGpt.model.chat.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChatRequest {


//    curl https://api.openai.com/v1/chat/completions \
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

    private List<Messages> messages;
    private String model;

}
