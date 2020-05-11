package com.tao.demo;

import java.io.Serializable;
import java.util.List;

public class WeiBo implements Serializable {

    private UserInfo userInfo;
    private List<CardInfo> cards;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<CardInfo> getCards() {
        return cards;
    }

    public void setCards(List<CardInfo> cards) {
        this.cards = cards;
    }
}
