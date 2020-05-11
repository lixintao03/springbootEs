package com.tao.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "card_info")
public class CardInfo {
    private String bid;
    private String user_id;
    private String cardType;
    private String text;
    private String created_at;
    private int pic_num;
    private String source;
    private long comments_count;
    private long attitudes_count;
    private List<PicInfo> pics;
    private String mid;
    private List<Comments> comments;

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getComments_count() {
        return comments_count;
    }

    public void setComments_count(long comments_count) {
        this.comments_count = comments_count;
    }

    public long getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(long attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreate_at(String created_at) {
        this.created_at = created_at;
    }

    public int getPic_num() {
        return pic_num;
    }

    public void setPic_num(int pic_num) {
        this.pic_num = pic_num;
    }

    public List<PicInfo> getPics() {
        return pics;
    }

    public void setPics(List<PicInfo> pics) {
        this.pics = pics;
    }
}
