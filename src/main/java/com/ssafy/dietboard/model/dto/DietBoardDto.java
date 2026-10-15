package com.ssafy.dietboard.model.dto;

public class DietBoardDto {
	private int DietBoardId;
	private int UserId;
	private int DietBoardWhen;
	private String DietBoardEat;
	private int DietBoardKcal;
		
	public DietBoardDto() {
		super();
	}

	public DietBoardDto(int dietBoardId, int userId, int dietBoardWhen, String dietBoardEat, int dietBoardKcal) {
		super();
		DietBoardId = dietBoardId;
		UserId = userId;
		DietBoardWhen = dietBoardWhen;
		DietBoardEat = dietBoardEat;
		DietBoardKcal = dietBoardKcal;
	}

	public int getDietBoardId() {
		return DietBoardId;
	}

	public void setDietBoardId(int dietBoardId) {
		DietBoardId = dietBoardId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getDietBoardWhen() {
		return DietBoardWhen;
	}

	public void setDietBoardWhen(int dietBoardWhen) {
		DietBoardWhen = dietBoardWhen;
	}

	public String getDietBoardEat() {
		return DietBoardEat;
	}

	public void setDietBoardEat(String dietBoardEat) {
		DietBoardEat = dietBoardEat;
	}

	public int getDietBoardKcal() {
		return DietBoardKcal;
	}

	public void setDietBoardKcal(int dietBoardKcal) {
		DietBoardKcal = dietBoardKcal;
	}

	@Override
	public String toString() {
		return "DietBoardDto [DietBoardId=" + DietBoardId + ", UserId=" + UserId + ", DietBoardWhen=" + DietBoardWhen
				+ ", DietBoardEat=" + DietBoardEat + ", DietBoardKcal=" + DietBoardKcal + "]";
	}
	
}
