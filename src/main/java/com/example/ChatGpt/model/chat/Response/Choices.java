package com.example.ChatGpt.model.chat.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Choices {

//    "choices": [{
//         * "index": 0,
//                "message": {
//            "role": "assistant",
//                    "content": "\n\nHello there, how may I assist you today?",
//        },
//        * "finish_reason": "stop"
    //}]

    private String finishReason;
    private Integer index;
    private Message message;
}
