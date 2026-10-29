package com.ssafy.dietboard.model.dto;

public class Diet {
	private String dietId;
	private String dietMenu;
	private int dietKcal;
	private double dietCarbs;
	private double dietProtein;
	private double dietFat;
	
	public Diet() {
		super();
	}

	public Diet(String dietId, String dietMenu, int dietKcal, double dietCarbs, double dietProtein, double dietFat) {
		super();
		this.dietId = dietId;
		this.dietMenu = dietMenu;
		this.dietKcal = dietKcal;
		this.dietCarbs = dietCarbs;
		this.dietProtein = dietProtein;
		this.dietFat = dietFat;
	}

	public String getDietId() {
		return dietId;
	}

	public void setDietId(String dietId) {
		this.dietId = dietId;
	}

	public String getDietMenu() {
		return dietMenu;
	}

	public void setDietMenu(String dietMenu) {
		this.dietMenu = dietMenu;
	}

	public int getDietKcal() {
		return dietKcal;
	}

	public void setDietKcal(int dietKcal) {
		this.dietKcal = dietKcal;
	}

	public double getDietCarbs() {
		return dietCarbs;
	}

	public void setDietCarbs(double dietCarbs) {
		this.dietCarbs = dietCarbs;
	}

	public double getDietProtein() {
		return dietProtein;
	}

	public void setDietProtein(double dietProtein) {
		this.dietProtein = dietProtein;
	}

	public double getDietFat() {
		return dietFat;
	}

	public void setDietFat(double dietFat) {
		this.dietFat = dietFat;
	}

	@Override
	public String toString() {
		return "Diet [dietId=" + dietId + ", dietMenu=" + dietMenu + ", dietKcal=" + dietKcal + ", dietCarbs="
				+ dietCarbs + ", dietProtein=" + dietProtein + ", dietFat=" + dietFat + "]";
	}
	
}
