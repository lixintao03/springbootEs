package com.tao.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "comments")
public class Comments {
    private String card_id;//关联微博id号
    private String mid;
    private String comment_id;//id号
    private String rootidstr;//根评论id号（当此评论就是根评论时，此号等于mid）
    private String text;//评论内容
    private String created_at;//评论时间
    private List<Comments> subComments;//子评论列表
    private String comment_user_id;//评论人id
    private String comment_screen_name;//品论人名称
    private String comment_description;//评论人描述
    private String comment_follow_count;//评论人关注数
    private String comment_followers_count;//评论人粉丝数
    private String comment_profile_image_url;//评论人头像
    private String comment_profile_url;//评论人主页

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getRootidstr() {
        return rootidstr;
    }

    public void setRootidstr(String rootidstr) {
        this.rootidstr = rootidstr;
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

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Comments> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comments> subComments) {
        this.subComments = subComments;
    }

    public String getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(String comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getComment_screen_name() {
        return comment_screen_name;
    }

    public void setComment_screen_name(String comment_screen_name) {
        this.comment_screen_name = comment_screen_name;
    }

    public String getComment_description() {
        return comment_description;
    }

    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }

    public String getComment_follow_count() {
        return comment_follow_count;
    }

    public void setComment_follow_count(String comment_follow_count) {
        this.comment_follow_count = comment_follow_count;
    }

    public String getComment_followers_count() {
        return comment_followers_count;
    }

    public void setComment_followers_count(String comment_followers_count) {
        this.comment_followers_count = comment_followers_count;
    }

    public String getComment_profile_image_url() {
        return comment_profile_image_url;
    }

    public void setComment_profile_image_url(String comment_profile_image_url) {
        this.comment_profile_image_url = comment_profile_image_url;
    }

    public String getComment_profile_url() {
        return comment_profile_url;
    }

    public void setComment_profile_url(String comment_profile_url) {
        this.comment_profile_url = comment_profile_url;
    }
}
