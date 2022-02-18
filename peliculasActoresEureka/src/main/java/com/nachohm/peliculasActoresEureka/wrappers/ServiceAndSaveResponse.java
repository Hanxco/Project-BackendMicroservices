package com.nachohm.peliculasActoresEureka.wrappers;

public class ServiceAndSaveResponse {

    public Integer code;
    public String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceAndSaveResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
