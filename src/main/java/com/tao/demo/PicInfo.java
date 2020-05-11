package com.tao.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pic_src")
public class PicInfo {
    private String bid;
    private String src;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
