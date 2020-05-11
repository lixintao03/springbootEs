package com.tao.demo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "friends",type = "user")
public class Friends implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845241017739813639L;
	@Id
	private String userId;
	private String userName;
	@GeoPointField
	private GeoPoint geo;
	private String place;

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public GeoPoint getGeo() {
		return geo;
	}

	public void setGeo(GeoPoint geo) {
		this.geo = geo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
