package com.tao.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_info")
public class UserInfo {
    private String user_id;
    private String screen_name;
    private String description;
    private long followers_count;
    private long follow_count;
    private String profile_image_url;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setId(String user_id) {
        this.user_id = user_id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

    public long getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(long follow_count) {
        this.follow_count = follow_count;
    }
}
