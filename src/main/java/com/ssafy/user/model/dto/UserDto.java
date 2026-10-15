package com.ssafy.user.model.dto;


public class UserDto {
	private int UUID;
	private String Id;
	private String Pw;
	private String UserName;
	private int UserHeight;
	private double UserWeight;
	


	public UserDto(int UUID, String Id, String Pw, String UserName, int UserHeight, double UserWeight) {
		this.UUID = UUID;
		this.Id = Id;
		this.Pw = Pw;
		this.UserName = UserName;
		this.UserHeight = UserHeight;
		this.UserWeight = UserWeight;
				
	}
	
	public UserDto () {
		
	}
	
	public int getUUID() {
		return UUID;
	}

	public void setUUID(int uUID) {
		UUID = uUID;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPw() {
		return Pw;
	}

	public void setPw(String pw) {
		Pw = pw;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public int getUserHeight() {
		return UserHeight;
	}

	public void setUserHeight(int userHeight) {
		UserHeight = userHeight;
	}

	public double getUserWeight() {
		return UserWeight;
	}

	public void setUserWeight(double userWeight) {
		UserWeight = userWeight;
	}

	@Override
	public String toString() {
		return "UserDto [UUID=" + UUID + ", Id=" + Id + ", Pw=" + Pw + ", UserName=" + UserName + ", UserHeight="
				+ UserHeight + ", UserWeight=" + UserWeight + "]";
	}


}
