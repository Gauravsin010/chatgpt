package com.example.ChatGpt.model.chat.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usage {

//    "usage": {
//        "prompt_tokens": 9,
//                "completion_tokens": 12,
//                "total_tokens": 21
//    }

    private Integer completionTokens;
    private Integer totalTokens;
    private Integer promptTokens;

}
