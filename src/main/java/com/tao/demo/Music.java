package com.tao.demo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Music implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8929497473717264499L;
	
	private String id;//歌曲名称
	private String name;//歌曲名称
	private String img;//图片地址
	private String url;//歌曲链接
	private String commentList;//列表名称
	private List<Comment> comments;//评论 

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCommentList() {
		return commentList;
	}

	public void setCommentList(String commentList) {
		this.commentList = commentList;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
