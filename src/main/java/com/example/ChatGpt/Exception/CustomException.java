package com.example.ChatGpt.Exception;

public class CustomException extends RuntimeException{
    public CustomException(String message, Throwable ex){
        super(message, ex);
    }
}
