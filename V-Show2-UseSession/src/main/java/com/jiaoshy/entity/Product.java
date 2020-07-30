package com.jiaoshy.entity;

public class Product {
	private int id;
	private String title;
	private String author;
	private String intro;
	private String imgPath;
	private int categoryId;
	
	private int viewCount;
	private int likeCount;
	
	
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Product(int id, String title, String author, String intro, String imgPath, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.intro = intro;
		this.imgPath = imgPath;
		this.categoryId = categoryId;
	}
	public Product(int id, String title, String author, String intro, String imgPath, int categoryId, int viewCount,
			int likeCount) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.intro = intro;
		this.imgPath = imgPath;
		this.categoryId = categoryId;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", author=" + author + ", intro=" + intro + ", imgPath="
				+ imgPath + ", categoryId=" + categoryId + ", viewCount=" + viewCount + ", likeCount=" + likeCount
				+ "]";
	}
	
	
	
}
