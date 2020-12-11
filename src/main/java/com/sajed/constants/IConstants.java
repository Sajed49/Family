package com.sajed.constants;

import com.sajed.models.ResponseModel;

public interface IConstants {
    String SUCCESS_STATUS = "Success";
    String FAILED_STATUS = "Failed";

    String MESSAGE_ERROR = "Server Error";
    String MESSAGE_SUCCESS = "Record fetching success";

    default <T> ResponseModel<T> convertToJSON(String status, String message, T data) {

        ResponseModel<T> result = new ResponseModel<T>();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

    void cleanError(Object object);
}
