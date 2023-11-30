package com.example.ChatGpt.model.image.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ImageRequest {

    private String prompt;

    private String model;

    private Integer n;

}
