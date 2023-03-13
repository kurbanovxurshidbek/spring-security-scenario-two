package com.springsecurity.scenariotwo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomApiException extends RuntimeException{
    private Integer errorCode;

    public CustomApiException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public static void throwException(String message , Integer errorCode)  {
        throw new CustomApiException(message, errorCode);
    }
}
