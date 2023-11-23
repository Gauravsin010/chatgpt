package com.example.ChatGpt.model.chat.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Messages {

    private String role;
    private String content;

}
