package com.example.miniprojectdelivery.model;
import lombok.Data;

@Data
public class Msg {
    private int statusCode;
    private String msg;
    public Msg(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }
}
