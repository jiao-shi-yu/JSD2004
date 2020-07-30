package com.jiaoshy.entity;

public class Banner {
	private int id;
	private String imgPath;
	public Banner(int id, String imgPath) {
		super();
		this.id = id;
		this.imgPath = imgPath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Banner [id=" + id + ", imgPath=" + imgPath + "]";
	}
	
	
}
