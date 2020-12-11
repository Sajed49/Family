package com.sajed.models;

import lombok.Data;

@Data
public class ResponseModel<T> {
    T data;
    private String status;
    private String message;
}
