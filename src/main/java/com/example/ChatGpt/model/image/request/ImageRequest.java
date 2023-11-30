package com.example.ChatGpt.model.image.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageRequest {


//    url https://api.openai.com/v1/images/generations \
//            -H "Content-Type: application/json" \
//            -H "Authorization: Bearer $OPENAI_API_KEY" \
//            -d '{
//            "model": "dall-e-3",
//            "prompt": "A cute baby sea otter",
//            "n": 1,
//            "size": "1024x1024"
//}'

    private String prompt;

    private String model;

    private Integer n;

}
