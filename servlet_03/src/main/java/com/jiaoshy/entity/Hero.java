package com.jiaoshy.entity;

public class Hero {
	private int id;
	private String heroName;
	private String HeroType;
	private int heroPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getHeroType() {
		return HeroType;
	}
	public void setHeroType(String heroType) {
		HeroType = heroType;
	}
	public int getHeroPrice() {
		return heroPrice;
	}
	public void setHeroPrice(int heroPrice) {
		this.heroPrice = heroPrice;
	}
	public Hero(int id, String heroName, String heroType, int heroPrice) {
		super();
		this.id = id;
		this.heroName = heroName;
		HeroType = heroType;
		this.heroPrice = heroPrice;
	}
	
	
	
}
