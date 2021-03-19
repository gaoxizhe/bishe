package com.example.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhengcm3
 * The Error Message entity class
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseBase {

    @JsonProperty(value = "code")
    private Integer code = 0;

    @JsonProperty(value = "msg")
    private String msg = "success";

    public RestResponseBase() {
        super();
    }

    public RestResponseBase(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
