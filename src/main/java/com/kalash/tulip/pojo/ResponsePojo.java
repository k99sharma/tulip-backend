package com.kalash.tulip.pojo;

public class ResponsePojo<T> {
    private String status;
    private String message;
    private T data;

    public ResponsePojo() {}

    public ResponsePojo(String status, String message){
        this.status = status;
        this.message = message;
    }

    public ResponsePojo(String status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
