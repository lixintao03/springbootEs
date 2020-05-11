package com.tao.demo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "gooods", type = "phone")
public class GoodsList {
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    private String goodsName;


}
