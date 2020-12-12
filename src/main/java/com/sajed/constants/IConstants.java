package com.sajed.constants;

import com.sajed.models.ResponseModel;

public interface IConstants {
    String SUCCESS_STATUS = "Success";
    String FAILED_STATUS = "Failed";

    String MESSAGE_PARENT_NOT_FOUND = "No Parent Found";
    String MESSAGE_ERROR = "Server Error";
    String MESSAGE_FETCH_SUCCESS = "Record fetching success";
    String MESSAGE_ADD_SUCCESS = "Record add success";
    String MESSAGE_UPDATE_SUCCESS = "Record update success";
    String MESSAGE_DELETE_SUCCESS = "Record delete success";

    /**
     * Converts an object dynamically to a response object for better API format with status message<p>
     *
     * @param status
     * @param message
     * @param data
     * @param <T>
     * @return ResponseModel
     * @author Sajed Jalil
     * @date 12-Dec-2020
     */
    default <T> ResponseModel<T> convertToJSON(String status, String message, T data) {

        ResponseModel<T> result = new ResponseModel<T>();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

    void cleanError(Object object);
}
