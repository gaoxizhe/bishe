package com.example.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestFileUploadResponse extends RestResponseBase {

    @JsonProperty(value = "downloadUrl")
    String downloadUrl;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
