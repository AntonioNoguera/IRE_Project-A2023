package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class Response_Model<T> {
    private T model;
    private String errorMessage;

    public Response_Model(T model, String errorMessage) {
        this.model = model;
        this.errorMessage = errorMessage;
    }

    public T getModel() {
        return model;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}