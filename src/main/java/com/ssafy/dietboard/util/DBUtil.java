package com.ssafy.dietboard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//연결정보
	private final String url = "jdbc:mysql://localhost:3306/nyamnyamcoach?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String password = "ssafy";
	private final String driverName = "com.mysql.cj.jdbc.Driver";
	
	//싱글턴
	private DBUtil() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 드라이버 로드
	}
	
	private static DBUtil util = new DBUtil();
	public static DBUtil getInstance() {
		return util;
	}
	//
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	//자원해제
	public void close(AutoCloseable...autoCloseables) {
		for(AutoCloseable c : autoCloseables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
