
package com.example.smallproject2.Domain;

public class BannerModel {
    private String url;

    //  Firebase के लिए जरूरी खाली constructor
    public BannerModel() {
    }

    public BannerModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
