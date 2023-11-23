package com.example.ChatGpt.model.chat.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChatResponse {

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

    private String id;
    private List<Choices> choices;
    private Integer created;
    private String model;
    private String systemFingerprint;
    private String object;
    private Usage usage;

}
