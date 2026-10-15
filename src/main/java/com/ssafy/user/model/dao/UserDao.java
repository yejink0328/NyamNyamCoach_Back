package com.ssafy.user.model.dao;


public class UserDao {
	
	private static UserDao instance;
	private UserDao() {}
	public static synchronized UserDao getInstance() {
		if(instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	
//	public UserDto selectLogin(UserDto parameter) {
//		String id = parameter.getId();
//		String pw = parameter.getPw();
//		
//		if(members.get(id) == null) {
//			System.out.println("id 없음");
//			return null;
//		}
//		if(members.get(id).equals(pw) == false ) {
//			System.out.println("pw 없음");
//			return null;
//		}
//		
//		Login login = new Login();
//		login.setId(id);
//		login.setPw(pw);
//		
//		login.setName("싸피");
//		
//		return login;
//	}
}
