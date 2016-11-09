package com.example.liuwangshu.mooneventbus;

/**
 * author andli
 * create at 16/11/9 下午5:07
 * 第一步：自定义一个事件类
 **/


public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
