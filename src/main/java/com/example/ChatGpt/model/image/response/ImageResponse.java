package com.example.ChatGpt.model.image.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ImageResponse {

    private List<Image> data;

}
