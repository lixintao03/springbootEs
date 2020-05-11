package com.tao.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5586741529773627115L;
	private String id;
	private String userName;//用户名
	private String headIconUrl;//头像url
	private List<Comment> comments;//本人发表过的评论

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
