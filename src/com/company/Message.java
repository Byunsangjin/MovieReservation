package com.company;

public class Message {
    private String id;
    private String password;
    private String msg;
    private String type;

    public Message() {}

    public Message(String id, String password, String msg, String type) {
        this.id = id;
        this.password =password;
        this.msg = msg;
        this.type = type;
    }
    public void setId (String id) {
        this.id = id;
    }
    public void setPassword (String password) {
        this.password = password;
    }
    public void setMsg (String msg) {
        this.msg = msg;
    }
    public void setType (String type) {
        this.type = type;
    }
    public String getId () {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getMsg() {
        return msg;
    }

    public String getType() {
        return type;
    }
}
