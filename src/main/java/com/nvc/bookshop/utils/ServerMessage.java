package com.nvc.bookshop.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ServerMessage {

    private Integer code;
    private String message;
    private Map<String, Object> data = new LinkedHashMap<>();

    private ServerMessage() {

    }

    private ServerMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ServerMessage success() {
        return new ServerMessage(100, "success");
    }

    public ServerMessage addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ServerMessage message(String message){
        this.message = message;
        return this;
    }

    public static ServerMessage getDefaultServerMessage(){
        return new ServerMessage();
    }

    public static ServerMessage error() {
        return new ServerMessage(200, "error");
    }

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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
