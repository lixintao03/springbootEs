package com.tao.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155390338276121373L;
	private String id;
	private String musicId;//被评论音乐id
	private String userId;//评论人id
	private String userName;//评论人
	private String headIconUrl;//评论人
	private Long zanCount;//被赞次数
	private String detail;//评论详情

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMusicId() {
		return musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadIconUrl() {
		return headIconUrl;
	}

	public void setHeadIconUrl(String headIconUrl) {
		this.headIconUrl = headIconUrl;
	}

	public Long getZanCount() {
		return zanCount;
	}

	public void setZanCount(Long zanCount) {
		this.zanCount = zanCount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
