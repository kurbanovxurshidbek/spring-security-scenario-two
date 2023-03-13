package com.springsecurity.scenariotwo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse {
    private String message;
    private Boolean success;
    private Object data;

    public static CustomResponse successMsg() {
        return CustomResponse
                .builder()
                .message("success")
                .success(true)
                .build();
    }

    public static CustomResponse successMsg(Object data) {
        return CustomResponse
                .builder()
                .message("success")
                .success(true)
                .data(data)
                .build();
    }

    public static CustomResponse errorMsg(Object data) {
        return CustomResponse
                .builder()
                .message("error")
                .success(false)
                .data(data)
                .build();
    }
}
