package com.accountmaker.springboot.service.dao;

public class SlackPayload {
    private static String text;

    public SlackPayload(String txt) { text = txt; }
    public  String toString() {
        return "{\"text\":\""+ text +"\"}";
    }
}
