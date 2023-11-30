package com.example.ChatGpt.util;

import com.example.ChatGpt.model.chat.Request.ChatRequest;
import com.example.ChatGpt.model.chat.Response.ChatResponse;
import com.example.ChatGpt.model.image.request.ImageRequest;
import com.example.ChatGpt.model.image.response.ImageResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ChatGptUtility {

    @Value("${chatgpt.api.key}")
    private String apiKey;

    @Value("${chatgpt.url}")
    private String url;

    @Value("${image.url}")
    private String imageUrl;


    public static final Logger logger = LoggerFactory.getLogger(ChatGptUtility.class);

    public ResponseEntity<ChatResponse> chatSearch(ChatRequest chatRequest) throws Exception {
        try {
            logger.info("Inside chatSearch method");
            HttpClient client = HttpClientBuilder.create().build();
            Gson gson = new GsonBuilder().create();
            String jsonStr = gson.toJson(chatRequest);
            logger.info("Request " + jsonStr);
            StringEntity params = new StringEntity(jsonStr);

            HttpPost request = new HttpPost(url);
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "Bearer " + apiKey);
            request.setEntity(params);

            HttpClientResponseHandler<String> responseHandler = classicHttpResponse -> {
                int status = classicHttpResponse.getCode();
                if(status >= 200 && status < 300){
                    HttpEntity entity = classicHttpResponse.getEntity();
                    logger.info("Entity " + entity);
                    if(entity != null){
                        return EntityUtils.toString(entity);
                    } else {
                        return null;
                    }
                } else {
                    throw new ClientProtocolException("Error Status " + status);
                }
            };

            String response = client.execute(request,responseHandler);
            logger.info("Response  " + response);

            Gson gsonOutput = new Gson();
            ChatResponse chatResponse = gsonOutput.fromJson(response, ChatResponse.class);
            logger.info("ChatResponse  " + chatResponse);

            if(chatResponse != null){
                return new ResponseEntity<>(chatResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception ex){
            logger.info("Exception inside chatSearch method");
            throw new Exception("Exception in parsing value " + ex.getMessage());
        }
    }

    public ResponseEntity<ImageResponse> createImage(ImageRequest imageRequest) throws Exception {
        try {
            logger.info("Inside createImage method");
            HttpClient client = HttpClientBuilder.create().build();
            Gson gson = new GsonBuilder().create();
            String jsonStr = gson.toJson(imageRequest);
            logger.info("Request " + jsonStr);
            StringEntity params = new StringEntity(jsonStr);

            HttpPost request = new HttpPost(imageUrl);
            request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "Bearer " + apiKey);
            request.setEntity(params);

            HttpClientResponseHandler<String> responseHandler = classicHttpResponse -> {
                int status = classicHttpResponse.getCode();
                if(status >= 200 && status < 300){
                    HttpEntity entity = classicHttpResponse.getEntity();
                    logger.info("Entity " + entity);
                    if(entity != null){
                        return EntityUtils.toString(entity);
                    } else {
                        return null;
                    }
                } else {
                    throw new ClientProtocolException("Error Status " + status);
                }
            };

            String response = client.execute(request, responseHandler);
            logger.info("Response  " + response);

            Gson gsonOutput = new Gson();
            ImageResponse result = gsonOutput.fromJson(response, ImageResponse.class);
            logger.info("ChatResponse  " + result);

            if(result != null){
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception ex){
            logger.info("Exception inside createImage method");
            throw new Exception("Exception in parsing value " + ex.getMessage());
        }
    }

}
