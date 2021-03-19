package com.example.model;

import lombok.Data;

import java.util.Arrays;

/**
 * @author gao
 */
@Data
public class RequestModel{
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
    private String username;


    private Object returnData;

    public RequestModel(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }

    public RequestModel(String url, String addr, String classMethod, Object[] args, String username) {
        this.url = url;
        this.ip = addr;
        this.classMethod = classMethod;
        this.args = args;
        this.username = username;
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args=" + Arrays.toString(args) +
                ", username='" + username + '\'' +
                '}';
    }
}