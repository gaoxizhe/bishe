package com.example.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestEntityResponse<T> extends RestResponseBase {

    @JsonProperty(value = "data")
    T data;

    @JsonProperty(value = "page")
    RestResponsePage page;

    public RestEntityResponse() {
        super();
    }

    public RestEntityResponse(T data) {
        super();
        this.data = data;
    }

    public RestEntityResponse(T data, RestResponsePage page) {
        super();
        this.data = data;
        this.page = page;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RestResponsePage getPage() {
        return page;
    }

    public void setPage(RestResponsePage page) {
        this.page = page;
    }

}