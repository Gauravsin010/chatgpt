package com.example.ChatGpt.model.chat.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

//    "message": {
//        "role": "assistant",
//                "content": "\n\nHello there, how may I assist you today?",
//    }
    private String role;
    private String content;

}
