package com.example.ChatGpt.model.image.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {

    private String b64_json;

    private String url;

    private String revised_prompt;

}
