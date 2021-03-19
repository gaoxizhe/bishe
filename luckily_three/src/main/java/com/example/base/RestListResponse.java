package com.example.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestListResponse<T> extends RestResponseBase {

    @JsonProperty(value = "data")
    List<T> data;

    @JsonProperty(value = "page")
    RestResponsePage page;

    public RestListResponse() {
        super();
    }

    public RestListResponse(List<T> data, RestResponsePage page) {
        super();
        this.data = data;
        this.page = page;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public RestResponsePage getPage() {
        return page;
    }

    public void setPage(RestResponsePage page) {
        this.page = page;
    }

}
